package drapps.cryptoheadquarters.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import drapps.cryptoheadquarters.CurrencyUtils;
import drapps.cryptoheadquarters.MainApplication;
import drapps.cryptoheadquarters.R;
import drapps.cryptoheadquarters.models.CoinCapResponse;
import drapps.cryptoheadquarters.models.Service;

/**
 * Created by diogo.rosa on 09/03/2018.
 */

public class CustomRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    List<CoinCapResponse> list = new ArrayList<>();
    Context context;
    Service serviceApi;
    private int mAppWidgetId;


    public CustomRemoteViewsFactory(List<CoinCapResponse> list, Context context, Intent intent) {
        this.list = list;
        this.context = context;
        serviceApi = ((MainApplication)context).getService();
        mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);;

    }

    @Override
    public void onCreate() {
        Log.i("ONCREATE", "FACTORY");

    }

    @Override
    public void onDataSetChanged() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.row_coin_simple);
        remoteViews.setTextViewText(R.id.txt_coin_name, list.get(position).getSymbol());
        remoteViews.setTextViewText(R.id.txt_coin_price, CurrencyUtils.toSelectedCurrency(context,list.get(position).getPrice()));
        remoteViews.setImageViewResource(R.id.iv_coin,context.getResources().getIdentifier(list.get(position).getSymbol().toLowerCase(), "drawable", context.getPackageName()));
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
