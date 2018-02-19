package drapps.leagueoflegendshq;

import android.content.Context;

import java.util.List;

import drapps.leagueoflegendshq.base.BasePresenter;
import drapps.leagueoflegendshq.coinlist.Coin;
import drapps.leagueoflegendshq.contracts.IView;

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
