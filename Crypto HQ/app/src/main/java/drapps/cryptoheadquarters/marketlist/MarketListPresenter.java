package drapps.cryptoheadquarters.marketlist;

import android.content.Context;

import java.util.List;

import drapps.cryptoheadquarters.base.BasePresenter;
import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.models.Market;
import drapps.cryptoheadquarters.usecases.GetMarketsFromMarketUseCase;

/**
 * Created by Diogo on 03/02/2018.
 */
public class MarketListPresenter extends BasePresenter implements ContractMarketList.Presenter {

    GetMarketsFromMarketUseCase useCase;
    ContractMarketList.View view;

    public MarketListPresenter(Context context) {
        super(context);
        useCase = new GetMarketsFromMarketUseCase(context, serviceAPI,this);
    }

    @Override
    public void attach(IView view) {
        this.view = (ContractMarketList.View) view;
    }

    @Override
    public void dettach() {

    }

    @Override
    public void requestMarketList(String exchange) {
        useCase.requestMarkets(exchange);
    }

    @Override
    public void onLoadedMarkets(List<Market> list) {
        super.onLoadedMarkets(list);
        view.onMarketsLoaded(list);
    }
}
