package drapps.cryptoheadquarters.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import drapps.cryptoheadquarters.R;
import drapps.cryptoheadquarters.coinlist.CoinDetailActivity;
import drapps.cryptoheadquarters.models.realmobjects.FavoriteCoin;
import io.realm.Realm;

import static com.tappx.b.n.a.i;

/**
 * Implementation of App Widget functionality.
 */
public class CoinListWidget extends AppWidgetProvider {

    public static final String ACTION_AUTO_UPDATE = "AUTO_UPDATE";

    public static final String WIDGET_IDS_KEY ="mywidgetproviderwidgetids";
    public static final String WIDGET_DATA_KEY ="mywidgetproviderwidgetdata";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.hasExtra(WIDGET_IDS_KEY)) {
            int[] ids = intent.getExtras().getIntArray(WIDGET_IDS_KEY);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            appWidgetManager.notifyAppWidgetViewDataChanged(ids, R.id.lv_appwidget);
            Intent intent2 = new Intent(context.getApplicationContext(),
                    RemoteViewsService.class);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);

            // Update the widgets via the service
            context.startService(intent2);
            //this.onUpdate(context, AppWidgetManager.getInstance(context), ids);
        } else super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        Log.i("FDS", "widgetUDAPTE");

        for (int i = 0; i <appWidgetIds.length; i++) {
            Intent intent = new Intent(context, CoinWidgetService.class);
            Log.i("FDS", "widgetUDAPTE");

            // Add the app widget ID to the intent extras.
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.coin_list_widget);
            views.setRemoteAdapter(R.id.lv_appwidget, intent);


            AppWidgetManager appWidgetManagerr = AppWidgetManager.getInstance(context);
                Intent intentUpdate = new Intent(context, CoinListWidget.class);
                intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

                PendingIntent pendingUpdate = PendingIntent.getBroadcast(
                        context, appWidgetIds[i], intentUpdate,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                views.setOnClickPendingIntent(R.id.btn_update, pendingUpdate);


            if(Realm.getDefaultInstance().where(FavoriteCoin.class).findAll().size() == 0){
                views.setViewVisibility(R.id.txt_empty, View.VISIBLE);
            }

            appWidgetManager.updateAppWidget(appWidgetIds, views);
        }
    }

    @Override
    public void onEnabled(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.coin_list_widget);
        Log.i("FDS", "widget");
        appWidgetManager.updateAppWidget(new ComponentName(context.getPackageName(),getClass().getName()), views);
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

