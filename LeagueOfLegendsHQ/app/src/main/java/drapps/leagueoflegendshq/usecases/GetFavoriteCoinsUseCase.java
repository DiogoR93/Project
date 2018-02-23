package drapps.leagueoflegendshq.usecases;

import android.content.Context;
import android.util.Log;

import java.util.List;

import drapps.leagueoflegendshq.base.BasePresenter;
import drapps.leagueoflegendshq.models.CoinCapResponse;
import drapps.leagueoflegendshq.models.Service;
import drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin;
import io.realm.Realm;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Diogo on 11/02/2018.
 */
public class GetFavoriteCoinsUseCase extends BaseGeneralUseCase{

    Realm realm;

    public GetFavoriteCoinsUseCase(Context context, Service serviceApi, BasePresenter presenter) {
        super(context, serviceApi, presenter);
        realm = Realm.getDefaultInstance();
    }

    public void getFavoriteCoins(){
        for(FavoriteCoin fc : realm.where(FavoriteCoin.class).findAll()) {
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
                            Log.i("COIN", response.get(0).getChangePercentage());
                        }
                    });
        }

    }



    /*public List<Coin> getFavoriteCoins(){
        for(FavoriteCoin fc : realm.where(FavoriteCoin.class).findAll()) {
            rx.Observable<CoinsResponse> observable = serviceApi.getCoins();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<CoinsResponse>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(CoinsResponse response) {
                            presenter.onLoadedCoins(response.getResults());
                            Log.i("COIN", response.getResults().get(0).getName());
                        }
                    });
        }

    }*/
}
