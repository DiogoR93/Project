package drapps.leagueoflegendshq.exchangeslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import drapps.leagueoflegendshq.marketlist.MarketListActivity;
import drapps.leagueoflegendshq.base.BaseCustomFragment;
import drapps.leagueoflegendshq.R;
import drapps.leagueoflegendshq.coinlist.CoinListFragment;
import drapps.leagueoflegendshq.exchangeslist.contracts.ContractAllListMain;
import drapps.leagueoflegendshq.models.Exchange;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Diogo on 02/02/2018.
 */
public class AllListFragment extends BaseCustomFragment implements ContractAllListMain.View{

    AllListPresenter presenter;
    RecyclerView rvOfList;
    ExchangeAdaper adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rv_layout, container, false);
        setupPresenter();
        bindViews(view);

         return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.requestExchanges();
    }



    @Override
    public void onExchangesRequested(List<Exchange> list) {
        adapter.swapContent(list);
        adapter.notifyDataSetChanged();
        Log.i("Exchnages", list.get(0).getName());
    }

    @Override
    public void bindViews(View view) {
        rvOfList = (RecyclerView) view.findViewById(R.id.rv_widget);
        rvOfList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ExchangeAdaper(getContext());
        rvOfList.setAdapter(adapter);

        adapter.publishSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Exchange>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Exchange exchange) {
                        CoinListFragment fragment = new CoinListFragment();
                        fragment.setExchange(exchange);
                        ((MarketListActivity)getActivity()).replaceFragment(fragment);
                    }
                });
    }

    @Override
    public void setupPresenter() {
        presenter = new AllListPresenter(getContext());
        presenter.attach(this);
    }
}
