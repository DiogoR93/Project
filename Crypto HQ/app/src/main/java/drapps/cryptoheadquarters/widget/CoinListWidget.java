package drapps.cryptoheadquarters.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;

import drapps.cryptoheadquarters.R;

import static com.tappx.b.n.a.i;

/**
 * Implementation of App Widget functionality.
 */
public class CoinListWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        Log.i("FDS", "widgetUDAPTE");

        for (int i = 0; i <appWidgetIds.length; i++) {
            Intent intent = new Intent(context, CoinWidgetService.class);
            // Add the app widget ID to the intent extras.
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.coin_list_widget);

            views.setRemoteAdapter(R.id.lv_appwidget, intent);

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

