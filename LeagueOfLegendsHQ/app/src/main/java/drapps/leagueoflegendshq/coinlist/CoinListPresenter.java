package drapps.leagueoflegendshq.coinlist;

import android.content.Context;

import java.util.List;

import drapps.leagueoflegendshq.ContractMarketList;
import drapps.leagueoflegendshq.base.BasePresenter;
import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.models.Market;
import drapps.leagueoflegendshq.usecases.GetMarketsFromMarketUseCase;

/**
 * Created by Diogo on 03/02/2018.
 */
public class CoinListPresenter extends BasePresenter implements ContractCoinList.Presenter{

    GetAllCoinsUseCase useCase;
    ContractCoinList.View view;

    public CoinListPresenter(Context context) {
        super(context);
        useCase = new GetAllCoinsUseCase(context, serviceAPI,this);
    }

    @Override
    public void attach(IView view) {
        this.view = (ContractCoinList.View) view;
    }

    @Override
    public void dettach() {

    }

    @Override
    public void onLoadedCoins(List<Coin> list) {
        super.onLoadedCoins(list);
        view.onCoinsLoaded(list);
    }

    @Override
    public void requestCoinList() {
        useCase.requestAllCoins();
    }
}
