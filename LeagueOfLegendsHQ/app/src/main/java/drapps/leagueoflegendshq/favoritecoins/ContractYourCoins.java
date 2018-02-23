package drapps.leagueoflegendshq.favoritecoins;

import java.util.List;

import drapps.leagueoflegendshq.coinlist.Coin;
import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.contracts.Ipresenter;

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
