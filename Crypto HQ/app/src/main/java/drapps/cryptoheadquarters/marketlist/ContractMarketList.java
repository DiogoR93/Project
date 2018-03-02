package drapps.cryptoheadquarters.marketlist;

import java.util.List;

import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.contracts.Ipresenter;
import drapps.cryptoheadquarters.models.Market;

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
