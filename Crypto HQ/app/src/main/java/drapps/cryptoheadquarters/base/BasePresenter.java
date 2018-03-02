package drapps.cryptoheadquarters.base;

import android.content.Context;

import java.util.List;

import drapps.cryptoheadquarters.MainApplication;
import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.contracts.Ipresenter;
import drapps.cryptoheadquarters.models.CoinCapResponse;
import drapps.cryptoheadquarters.models.CoinCapSingleCoinResponse;
import drapps.cryptoheadquarters.models.Exchange;
import drapps.cryptoheadquarters.models.GraphDataResponse;
import drapps.cryptoheadquarters.models.Market;
import drapps.cryptoheadquarters.models.Service;

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

    public void onLoadedCoins(List<CoinCapResponse> list){
    }

    public void onLoadedCoinGraphData(GraphDataResponse response){

    }

    public Service getServiceAPI() {
        return serviceAPI;
    }

    public void onLoadedCoinInfo(CoinCapSingleCoinResponse response) {
    }
}
