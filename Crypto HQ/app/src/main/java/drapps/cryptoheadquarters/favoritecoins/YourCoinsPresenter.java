package drapps.cryptoheadquarters.favoritecoins;

import android.content.Context;

import java.util.List;

import drapps.cryptoheadquarters.base.BasePresenter;
import drapps.cryptoheadquarters.coinlist.Coin;
import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.usecases.GetFavoriteCoinsUseCase;

/**
 * Created by Diogo on 11/02/2018.
 */
public class YourCoinsPresenter extends BasePresenter implements ContractYourCoins.Presenter {

    ContractYourCoins.View view;
    GetFavoriteCoinsUseCase useCase;

    public YourCoinsPresenter(Context context) {
        super(context);
        useCase = new GetFavoriteCoinsUseCase(context, serviceAPI, this);
    }

    @Override
    public List<Coin> requestCoin(String coin) {
        return null;
    }

    @Override
    public void attach(IView view) {
        this.view = (ContractYourCoins.View) view;
    }

    @Override
    public void dettach() {

    }
}
