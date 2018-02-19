package drapps.leagueoflegendshq.coinlist;

import java.util.List;

import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.contracts.Ipresenter;
import drapps.leagueoflegendshq.models.Market;

/**
 * Created by Diogo on 03/02/2018.
 */

public interface ContractCoinList {
    interface View extends IView{
        void onCoinsLoaded(List<Coin> list);
    }

    interface Presenter extends Ipresenter{
        void requestCoinList();
    }
}
