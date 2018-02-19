package drapps.leagueoflegendshq;

import android.content.Context;

import java.util.List;

import drapps.leagueoflegendshq.base.BasePresenter;
import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.models.Market;
import drapps.leagueoflegendshq.usecases.GetMarketsFromMarketUseCase;

/**
 * Created by Diogo on 03/02/2018.
 */
public class MarketListPresenter extends BasePresenter implements ContractMarketList.Presenter{

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
