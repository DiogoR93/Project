package drapps.leagueoflegendshq.exchangeslist;

import android.content.Context;

import java.util.List;

import drapps.leagueoflegendshq.base.BasePresenter;
import drapps.leagueoflegendshq.exchangeslist.contracts.ContractAllListMain;
import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.models.Exchange;
import drapps.leagueoflegendshq.usecases.GetExchangesUseCase;

/**
 * Created by Diogo on 03/02/2018.
 */
public class AllListPresenter extends BasePresenter implements ContractAllListMain.Presenter{

    ContractAllListMain.View view;
    GetExchangesUseCase useCase;

    public AllListPresenter(Context context) {
        super(context);
        useCase = new GetExchangesUseCase(context,serviceAPI, this);
    }

    @Override
    public void attach(IView view) {
        this.view = (ContractAllListMain.View) view;
    }

    @Override
    public void dettach() {

    }

    @Override
    public void requestExchanges() {
        useCase.requestExchanges();
    }

    @Override
    public void onLoadedExchanges(List<Exchange> exchanges) {
        view.onExchangesRequested(exchanges);
        super.onLoadedExchanges(exchanges);
    }
}
