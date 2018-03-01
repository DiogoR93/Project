package drapps.leagueoflegendshq.coinlist;

import android.content.Context;

import java.util.List;

import drapps.leagueoflegendshq.base.BasePresenter;
import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.models.CoinCapSingleCoinResponse;
import drapps.leagueoflegendshq.models.GraphDataResponse;

/**
 * Created by diogo.rosa on 26/02/2018.
 */

public class CoinDetailPresenter extends BasePresenter implements ContractCoinDetail.Presenter{

    GetCoinDataUseCase getCoinDataUseCase;
    CoinDetailActivity act;

    public CoinDetailPresenter(Context context) {
        super(context);
        getCoinDataUseCase = new GetCoinDataUseCase(context,serviceAPI,this);
    }

    @Override
    public void attach(IView view) {
        act = (CoinDetailActivity) view;
    }

    @Override
    public void dettach() {

    }

    @Override
    public void loadCoinGraphData(String coinName) {
        getCoinDataUseCase.getCoinDataForGraph(coinName);
    }

    @Override
    public void loadCointInfo(String coin) {
        getCoinDataUseCase.getCoinInfo(coin);
    }

    @Override
    public void onLoadedCoinInfo(CoinCapSingleCoinResponse response) {
        super.onLoadedCoinInfo(response);
        act.onLoadedCoinCapInfo(response);

    }

    @Override
    public void onLoadedCoinGraphData(GraphDataResponse response) {
        super.onLoadedCoinGraphData(response);
        act.onLoadedCoinCapGraphData(response);
    }
}
