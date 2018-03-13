package drapps.cryptoheadquarters;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import drapps.cryptoheadquarters.widget.CoinListWidget;

/**
 * Created by diogo.rosa on 12/03/2018.
 */

public class Utils {

    public static void updateMyWidgets(Context context, Parcelable data) {
        AppWidgetManager man = AppWidgetManager.getInstance(context);
        int[] ids = man.getAppWidgetIds(
                new ComponentName(context,CoinListWidget.class));
        Intent updateIntent = new Intent();
        updateIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        updateIntent.putExtra(CoinListWidget.WIDGET_IDS_KEY, ids);
        context.sendBroadcast(updateIntent);

        /*int[] ids = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, CoinListWidget.class));
        CoinListWidget myWidget = new CoinListWidget();
        myWidget.onUpdate(context, AppWidgetManager.getInstance(context),ids);*/
    }
}
