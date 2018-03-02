package drapps.cryptoheadquarters.marketlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import drapps.cryptoheadquarters.R;
import drapps.cryptoheadquarters.base.BaseCustomFragment;
import drapps.cryptoheadquarters.models.Exchange;
import drapps.cryptoheadquarters.models.Market;

/**
 * Created by Diogo on 03/02/2018.
 */

public class MarketListFragment extends BaseCustomFragment implements ContractMarketList.View {

    MarketListPresenter presenter;
    Exchange exchange;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rv_layout, container, false);
        setupPresenter();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.requestMarketList(exchange.getName().toLowerCase());
    }

    @Override
    public void bindViews(View view) {

    }

    @Override
    public void setupPresenter() {
        presenter = new MarketListPresenter(getContext());
        presenter.attach(this);
    }

    @Override
    public void onMarketsLoaded(List<Market> list) {

    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }
}
