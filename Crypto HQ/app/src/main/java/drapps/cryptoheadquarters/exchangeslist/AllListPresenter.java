package drapps.cryptoheadquarters.exchangeslist;

import android.content.Context;

import java.util.List;

import drapps.cryptoheadquarters.base.BasePresenter;
import drapps.cryptoheadquarters.exchangeslist.contracts.ContractAllListMain;
import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.models.Exchange;
import drapps.cryptoheadquarters.usecases.GetExchangesUseCase;

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
