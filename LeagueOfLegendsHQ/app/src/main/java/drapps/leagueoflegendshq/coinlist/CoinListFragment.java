package drapps.leagueoflegendshq.coinlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import drapps.leagueoflegendshq.ContractMarketList;
import drapps.leagueoflegendshq.MainActivity;
import drapps.leagueoflegendshq.R;
import drapps.leagueoflegendshq.adapters.CoinAdaper;
import drapps.leagueoflegendshq.base.BaseCustomFragment;
import drapps.leagueoflegendshq.models.Exchange;
import drapps.leagueoflegendshq.models.Market;
import drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin;
import io.realm.Realm;
import rx.Scheduler;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rv_layout, container, false);
        bindViews(view );
        setupPresenter();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.requestCoinList();
    }

    @Override
    public void bindViews(View view) {
        rvCoins = (RecyclerView) view.findViewById(R.id.rv_widget);
        adaper = new CoinAdaper(getContext());
        rvCoins.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCoins.setAdapter(adaper);
        adaper.getPublishSubject().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Coin>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Coin coin) {
                        FavoriteCoin favoriteCoin = new FavoriteCoin(exchange.getName(),coin.getName(), coin.getSymbol());
                        Realm.getDefaultInstance().beginTransaction();
                        Realm.getDefaultInstance().insertOrUpdate(favoriteCoin);
                        Realm.getDefaultInstance().commitTransaction();
                        startActivity(new Intent(getContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    }
                });

    }

    @Override
    public void setupPresenter() {
        presenter = new CoinListPresenter(getContext());
        presenter.attach(this);
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void onCoinsLoaded(List<Coin> list) {
        Log.i("TESTE", "TESTE");
        try {
            adaper.swapContent(list);
            adaper.notifyDataSetChanged();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
