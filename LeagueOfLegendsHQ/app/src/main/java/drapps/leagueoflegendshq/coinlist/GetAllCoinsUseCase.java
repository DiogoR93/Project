package drapps.leagueoflegendshq.coinlist;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import drapps.leagueoflegendshq.base.BasePresenter;
import drapps.leagueoflegendshq.models.CoinCapResponse;
import drapps.leagueoflegendshq.models.CoinsResponse;
import drapps.leagueoflegendshq.models.Market;
import drapps.leagueoflegendshq.models.MarketsFromExchangeResponse;
import drapps.leagueoflegendshq.models.Service;
import drapps.leagueoflegendshq.models.SingleMarketFromExchangeResponse;
import drapps.leagueoflegendshq.usecases.BaseGeneralUseCase;
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
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<CoinCapResponse> response) {
                        presenter.onLoadedCoins(response);
                        Log.i("COIN", response.get(0).getChangePercentage()+"");
                    }
                });
    }
}
