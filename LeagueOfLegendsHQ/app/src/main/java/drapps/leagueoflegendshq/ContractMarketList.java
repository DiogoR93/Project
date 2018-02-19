package drapps.leagueoflegendshq;

import java.util.List;

import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.contracts.Ipresenter;
import drapps.leagueoflegendshq.models.Market;

/**
 * Created by Diogo on 03/02/2018.
 */

public interface ContractMarketList {
    interface View extends IView{
        void onMarketsLoaded(List<Market> list);
    }

    interface Presenter extends Ipresenter{
        void requestMarketList(String exchange);
    }
}
