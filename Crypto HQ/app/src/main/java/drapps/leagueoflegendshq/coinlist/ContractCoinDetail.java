package drapps.leagueoflegendshq.coinlist;

import java.util.List;

import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.contracts.Ipresenter;
import drapps.leagueoflegendshq.models.CoinCapSingleCoinResponse;
import drapps.leagueoflegendshq.models.GraphDataResponse;

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
