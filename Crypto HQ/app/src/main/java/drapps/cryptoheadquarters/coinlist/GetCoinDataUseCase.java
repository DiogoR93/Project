package drapps.cryptoheadquarters.coinlist;

import android.content.Context;
import android.util.Log;

import com.tappx.sdk.android.BaseAdActivity;

import drapps.cryptoheadquarters.base.BaseCustomActivity;
import drapps.cryptoheadquarters.base.BasePresenter;
import drapps.cryptoheadquarters.models.CoinCapSingleCoinResponse;
import drapps.cryptoheadquarters.models.GraphDataResponse;
import drapps.cryptoheadquarters.models.Service;
import drapps.cryptoheadquarters.usecases.BaseGeneralUseCase;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by diogo.rosa on 26/02/2018.
 */

public class GetCoinDataUseCase extends BaseGeneralUseCase{
    public GetCoinDataUseCase(Context context, Service serviceApi, BasePresenter presenter) {
        super(context, serviceApi, presenter);
    }

    public void getCoinDataForGraph(String coinName){
        ((BaseCustomActivity) context).startLoading();
        rx.Observable<GraphDataResponse> observable = serviceApi.getGraphData(coinName);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GraphDataResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        ((BaseCustomActivity) context).stopLoading();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(GraphDataResponse response) {
                        try {
                            Log.i("COINDATA", response.getPrice().get(0)[1] + "");
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        presenter.onLoadedCoinGraphData(response);
                        ((BaseCustomActivity) context).stopLoading();
                    }
                });
    }

    public void getCoinInfo(String coin) {
        rx.Observable<CoinCapSingleCoinResponse> observable = serviceApi.getCoinInfo(coin);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CoinCapSingleCoinResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CoinCapSingleCoinResponse response) {

                        presenter.onLoadedCoinInfo(response);
                    }
                });
    }
}
