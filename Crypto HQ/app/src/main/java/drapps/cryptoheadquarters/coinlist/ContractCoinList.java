package drapps.cryptoheadquarters.coinlist;

import java.util.List;

import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.contracts.Ipresenter;
import drapps.cryptoheadquarters.models.CoinCapResponse;

/**
 * Created by Diogo on 03/02/2018.
 */

public interface ContractCoinList {
    interface View extends IView{
        void onCoinsLoaded(List<CoinCapResponse> list);
    }

    interface Presenter extends Ipresenter{
        void requestCoinList();
    }
}
