package drapps.leagueoflegendshq.base;

import android.content.Context;
import android.view.View;

import java.util.List;

import drapps.leagueoflegendshq.MainApplication;
import drapps.leagueoflegendshq.coinlist.Coin;
import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.contracts.Ipresenter;
import drapps.leagueoflegendshq.models.Exchange;
import drapps.leagueoflegendshq.models.Market;
import drapps.leagueoflegendshq.models.Service;

/**
 * Created by Diogo on 03/02/2018.
 */
public abstract class BasePresenter implements Ipresenter{

    protected Service serviceAPI;
    public IView view;
    protected Context context;

    public BasePresenter(Context context) {
        this.context = context;
        this.serviceAPI = ((MainApplication) context.getApplicationContext()).getService();
    }

    public void onLoadedExchanges(List<Exchange> exchanges) {
    }

    public void onLoadedMarkets(List<Market> list){
    }

    public void onLoadedCoins(List<Coin> list){
    }
}
