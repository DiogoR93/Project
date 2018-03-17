package drapps.cryptoheadquarters.coinlist;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import drapps.cryptoheadquarters.CurrencyUtils;
import drapps.cryptoheadquarters.MainActivity;
import drapps.cryptoheadquarters.MainApplication;
import drapps.cryptoheadquarters.R;
import drapps.cryptoheadquarters.adapters.CoinAdaper;
import drapps.cryptoheadquarters.base.BaseCustomFragment;
import drapps.cryptoheadquarters.models.CoinCapResponse;
import drapps.cryptoheadquarters.models.Exchange;
import drapps.cryptoheadquarters.models.realmobjects.FavoriteCoin;
import io.realm.Realm;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Diogo on 03/02/2018.
 */

public class CoinListFragment extends BaseCustomFragment implements ContractCoinList.View{

    CoinListPresenter presenter;
    Exchange exchange;
    CoinAdaper adaper;
    RecyclerView rvCoins;
    RadioButton rbGeneral;
    RadioButton rbFavorits;
    boolean isFavoritesSelected = false;
    List<CoinCapResponse> listGeneral = new ArrayList<>();
    List<CoinCapResponse> listFavorite = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rv_layout_coins, container, false);
        bindViews(view );
        setupPresenter();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        rbFavorits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbFavorits.setTypeface(Typeface.DEFAULT_BOLD);
                rbGeneral.setTypeface(Typeface.DEFAULT);
                ((MainActivity) getActivity()).getEtSearch().setText("");
                isFavoritesSelected = true;
                adaper.swapContent(listFavorite);
            }
        });

        rbGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbFavorits.setTypeface(Typeface.DEFAULT);
                rbGeneral.setTypeface(Typeface.DEFAULT_BOLD);
                isFavoritesSelected = false;
                ((MainActivity) getActivity()).getEtSearch().setText("");
                adaper.swapContent(listGeneral);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        if(((MainActivity) getActivity()).getCurrentPageSelected() == 0){
            presenter.requestCoinList();
        }
    }

    @Override
    public void bindViews(View view) {
        rvCoins = view.findViewById(R.id.rv_widget);
        rbFavorits = view.findViewById(R.id.tab_card_favorits);
        rbGeneral = view.findViewById(R.id.tab_card_general);
        adaper = new CoinAdaper(getContext());
        rvCoins.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCoins.setAdapter(adaper);
        adaper.getPublishSubject().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CoinCapResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CoinCapResponse coin) {
                        startActivity(new Intent(getContext(), CoinDetailActivity.class).putExtra("coin", coin.getSymbol().toUpperCase()).putExtra("price", CurrencyUtils.toSelectedCurrency(getContext(),coin.getPrice())));
                        /*FavoriteCoin favoriteCoin = new FavoriteCoin(exchange.getName(),coin.getName(), coin.getSymbol());
                        Realm.getDefaultInstance().beginTransaction();
                        Realm.getDefaultInstance().insertOrUpdate(favoriteCoin);
                        Realm.getDefaultInstance().commitTransaction();
                        startActivity(new Intent(getContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));*/
                    }
                });
        if(getActivity() != null)
        ((MainActivity) getActivity()).getEtSearch().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adaper.applyFilter(((MainActivity) getActivity()).getEtSearch().getText().toString().trim());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        ((MainActivity) getActivity()).getSwipeRefreshLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.requestCoinList();
            }
        });

    }

    @Override
    public void setupPresenter() {
        presenter = new CoinListPresenter(getContext(), this);
        presenter.attach(this);
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void onCoinsLoaded(List<CoinCapResponse> list) {
        try {
            this.listFavorite.clear();
            this.listGeneral.clear();
            listGeneral.addAll(list);
            for(CoinCapResponse cr : list){
                if(Realm.getDefaultInstance().where(FavoriteCoin.class).equalTo("coinSymbol", cr.getSymbol()).findFirst() != null){
                    listFavorite.add(cr);
                }
            }
            if (isFavoritesSelected){
                adaper.swapContent(listFavorite);
            }else {
                adaper.swapContent(listGeneral);
            }
            adaper.notifyDataSetChanged();
            adaper.applyFilter(((MainActivity) getActivity()).getEtSearch().getText().toString().trim());
            ((MainActivity) getActivity()).getSwipeRefreshLayout().setRefreshing(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
