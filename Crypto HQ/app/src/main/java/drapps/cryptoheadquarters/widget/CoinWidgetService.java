package drapps.cryptoheadquarters.widget;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

import drapps.cryptoheadquarters.MainApplication;
import drapps.cryptoheadquarters.R;
import drapps.cryptoheadquarters.models.CoinCapResponse;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by diogo.rosa on 09/03/2018.
 */

public class CoinWidgetService extends RemoteViewsService{

    List<CoinCapResponse> list = new ArrayList<>();

    @Override
    public RemoteViewsFactory onGetViewFactory(final Intent intent) {
        final CustomRemoteViewsFactory customRemoteViewsFactory = new CustomRemoteViewsFactory(list, getApplicationContext(),intent);
        Log.i("Widget----", "HERE");
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
                        Log.i("COIN", response.get(0).getChangePercentage()+"");
                        Log.i("Widget----", "HERE2");

                        list.addAll(response.subList(1,8));
                        AppWidgetManager manager = AppWidgetManager.getInstance(getApplicationContext());
                        manager.notifyAppWidgetViewDataChanged(intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,0), R.id.lv_appwidget);
                        Log.i("Widget----", "HERE"+                        customRemoteViewsFactory.getCount());
                    }
                });
        return customRemoteViewsFactory;

    }
}
