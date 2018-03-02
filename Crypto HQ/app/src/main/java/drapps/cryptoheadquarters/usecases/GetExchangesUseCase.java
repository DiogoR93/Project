package drapps.cryptoheadquarters.usecases;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import drapps.cryptoheadquarters.base.BasePresenter;
import drapps.cryptoheadquarters.models.Exchange;
import drapps.cryptoheadquarters.models.ExchangesResponse;
import drapps.cryptoheadquarters.models.Service;
import drapps.cryptoheadquarters.models.SingleExchangeResponse;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Diogo on 03/02/2018.
 */

public class GetExchangesUseCase extends BaseGeneralUseCase {

    public GetExchangesUseCase(Context context, Service serviceApi, BasePresenter presenter) {
        super(context, serviceApi, presenter);
    }

    public void requestExchanges() {
            rx.Observable<ExchangesResponse> observable = serviceApi.getALlExchanges();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ExchangesResponse>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(ExchangesResponse generalResponse) {
                            List<Exchange> list = new ArrayList<>();
                            for(SingleExchangeResponse response : generalResponse.getResult()) {
                                list.add(new Exchange(response.getName(), response.getRoute(), response.getSymbol()));
                            }
                            presenter.onLoadedExchanges(list);
                        }
                    });
    }
}
