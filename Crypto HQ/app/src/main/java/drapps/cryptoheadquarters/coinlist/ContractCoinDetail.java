package drapps.cryptoheadquarters.coinlist;

import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.contracts.Ipresenter;
import drapps.cryptoheadquarters.models.CoinCapSingleCoinResponse;
import drapps.cryptoheadquarters.models.GraphDataResponse;

/**
 * Created by diogo.rosa on 26/02/2018.
 */

public interface ContractCoinDetail {
    interface View extends IView{
        void onLoadedCoinCapInfo(CoinCapSingleCoinResponse response);
        void onLoadedCoinCapGraphData(GraphDataResponse response);
    }
    interface Presenter extends Ipresenter{
        void loadCoinGraphData(String coin);
        void loadCointInfo(String coin);}
}
