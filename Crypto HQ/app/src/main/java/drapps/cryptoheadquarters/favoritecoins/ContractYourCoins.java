package drapps.cryptoheadquarters.favoritecoins;

import java.util.List;

import drapps.cryptoheadquarters.coinlist.Coin;
import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.contracts.Ipresenter;

/**
 * Created by Diogo on 10/02/2018.
 */

public interface ContractYourCoins {

    interface View extends IView{
        void onLoadedFavoriteCoins(List<Coin> coins);
    }

    interface Presenter extends Ipresenter{
        List<Coin> requestCoin(String coin);
    }

}
