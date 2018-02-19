package drapps.leagueoflegendshq.usecases;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import drapps.leagueoflegendshq.base.BasePresenter;
import drapps.leagueoflegendshq.models.Exchange;
import drapps.leagueoflegendshq.models.ExchangesResponse;
import drapps.leagueoflegendshq.models.Market;
import drapps.leagueoflegendshq.models.MarketsFromExchangeResponse;
import drapps.leagueoflegendshq.models.Service;
import drapps.leagueoflegendshq.models.SingleExchangeResponse;
import drapps.leagueoflegendshq.models.SingleMarketFromExchangeResponse;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Diogo on 03/02/2018.
 */

public class GetMarketsFromMarketUseCase extends BaseGeneralUseCase {
    public GetMarketsFromMarketUseCase(Context context, Service serviceApi, BasePresenter presenter) {
        super(context, serviceApi, presenter);
    }

    public void requestMarkets(String exchange){
        rx.Observable<MarketsFromExchangeResponse> observable = serviceApi.getMarketsFromExchange(exchange);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MarketsFromExchangeResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MarketsFromExchangeResponse generalResponse) {
                        List<Market> list = new ArrayList<>();
                        for(SingleMarketFromExchangeResponse response : generalResponse.getResult()) {
                            list.add(new Market(response.getPair(), response.getRoute(), response.isActive()));
                        }
                        presenter.onLoadedMarkets(list);
                    }
                });
    }
}
