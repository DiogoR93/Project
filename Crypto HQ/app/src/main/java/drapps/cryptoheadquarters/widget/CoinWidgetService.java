package drapps.cryptoheadquarters.widget;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

import drapps.cryptoheadquarters.MainApplication;
import drapps.cryptoheadquarters.R;
import drapps.cryptoheadquarters.models.CoinCapResponse;
import drapps.cryptoheadquarters.models.realmobjects.FavoriteCoin;
import io.realm.Realm;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by diogo.rosa on 09/03/2018.
 */

public class CoinWidgetService extends RemoteViewsService{

    List<CoinCapResponse> list = new ArrayList<>();
    Intent intente;

    @Override
    public RemoteViewsFactory onGetViewFactory( Intent intent) {
        this.intente = intent;
        CustomRemoteViewsFactory customRemoteViewsFactory = new CustomRemoteViewsFactory(list, getApplicationContext(),intent);
        rx.Observable<List<CoinCapResponse>> observable = ((MainApplication) getApplicationContext()).getService().getCoinsFromCoinCap();
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
                        for(CoinCapResponse cr : response){
                            if(Realm.getDefaultInstance().where(FavoriteCoin.class).equalTo("coinSymbol", cr.getSymbol()).findFirst() != null){
                                list.add(cr);
                            }
                        }
                        AppWidgetManager manager = AppWidgetManager.getInstance(getApplicationContext());
                        manager.notifyAppWidgetViewDataChanged(intente.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,0), R.id.lv_appwidget);
                    }
                });
        return customRemoteViewsFactory;

    }
}
