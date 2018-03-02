package drapps.cryptoheadquarters.coinlist;

import android.content.Context;
import android.util.Log;

import java.util.List;

import drapps.cryptoheadquarters.base.BasePresenter;
import drapps.cryptoheadquarters.models.CoinCapResponse;
import drapps.cryptoheadquarters.models.Service;
import drapps.cryptoheadquarters.usecases.BaseGeneralUseCase;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Diogo on 07/02/2018.
 */
public class GetAllCoinsUseCase  extends BaseGeneralUseCase{
    public GetAllCoinsUseCase(Context context, Service serviceApi, BasePresenter presenter) {
        super(context, serviceApi, presenter);
    }

    public void requestAllCoins() {
        rx.Observable<List<CoinCapResponse>> observable = serviceApi.getCoinsFromCoinCap();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<CoinCapResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        ((CoinListPresenter) presenter).stopLoading();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<CoinCapResponse> response) {
                        presenter.onLoadedCoins(response);
                        ((CoinListPresenter) presenter).stopLoading();
                        Log.i("COIN", response.get(0).getChangePercentage()+"");
                    }
                });
    }
}
