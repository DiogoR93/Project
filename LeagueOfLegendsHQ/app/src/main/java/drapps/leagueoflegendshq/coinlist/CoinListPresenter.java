package drapps.leagueoflegendshq.coinlist;

import android.content.Context;

import java.util.List;

import drapps.leagueoflegendshq.base.BaseCustomActivity;
import drapps.leagueoflegendshq.base.BaseCustomFragment;
import drapps.leagueoflegendshq.base.BasePresenter;
import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.models.CoinCapResponse;

/**
 * Created by Diogo on 03/02/2018.
 */
public class CoinListPresenter extends BasePresenter implements ContractCoinList.Presenter{

    GetAllCoinsUseCase useCase;
    ContractCoinList.View view;
    BaseCustomFragment fragment;

    public CoinListPresenter(Context context, BaseCustomFragment fragment) {
        super(context);
        useCase = new GetAllCoinsUseCase(context, serviceAPI,this);
        this.fragment = fragment;
    }

    @Override
    public void attach(IView view) {
        this.view = (ContractCoinList.View) view;
    }

    @Override
    public void dettach() {

    }

    @Override
    public void onLoadedCoins(List<CoinCapResponse> list) {
        super.onLoadedCoins(list);
        view.onCoinsLoaded(list);
    }

    @Override
    public void requestCoinList() {
        ((BaseCustomActivity) fragment.getActivity()).startLoading();
        useCase.requestAllCoins();
    }

    public void stopLoading(){
        ((BaseCustomActivity) fragment.getActivity()).stopLoading();
    }
}
