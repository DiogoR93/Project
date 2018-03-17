package drapps.cryptoheadquarters;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import br.com.goncalves.pugnotification.notification.PugNotification;
import drapps.cryptoheadquarters.models.CoinCapResponse;
import drapps.cryptoheadquarters.models.realmobjects.FavoriteCoin;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.realm.Realm;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Shaon on 4/10/2017.
 */

public class AlarmService extends Service {

    Intent intent1;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("TESTE1", "NOW1");

       /* PugNotification.with(getApplicationContext())
                .load()
                .title("teste")
                .message("message")
                .smallIcon(R.drawable.pugnotification_ic_launcher)
                .largeIcon(R.drawable.pugnotification_ic_launcher)
                .flags(Notification.DEFAULT_ALL)
                .simple()
                .build();*/

        Log.i("TESTE", "TESTEEEEEE");
        this.intent1 = intent;

        Log.i("TESTE2", "NOW2");

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
                        boolean done = false;
                        for (CoinCapResponse cr: response
                                ) {
                            if((cr.getSymbol().toLowerCase().equals(intent1.getStringExtra("coin"))))
                            {
                                if (intent1.getBooleanExtra("above", false)) {
                                    if (Double.valueOf(cr.getPrice()) >= intent1.getDoubleExtra("price", 0)) {
                                        showNotification(getApplicationContext(), intent1.getStringExtra("coin").toUpperCase() + ": " + getString(R.string.is_at)+" " + CurrencyUtils.toSelectedCurrency(getApplicationContext(),cr.getPrice()), "", new Intent());
                                        done = true;
                                    }
                                } else {
                                    if (Double.valueOf(cr.getPrice()) <= intent1.getDoubleExtra("price", 0)) {
                                        showNotification(getApplicationContext(), intent1.getStringExtra("coin").toUpperCase() + ": " + getString(R.string.is_at)+ " " + CurrencyUtils.toSelectedCurrency(getApplicationContext(),cr.getPrice()), "", new Intent());
                                        done = true;
                                    }
                                }
                            }

                        }
                        if(!done){
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                startForeground(1, null);
                            }
                        }
                    }
                });
        return START_NOT_STICKY;
    }

    public void showNotification(Context context, String title, String body, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            try {
                notificationManager.createNotificationChannel(mChannel);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(title)
                .setContentText(body)
                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

        intent = new Intent(getApplicationContext(), MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntent(intent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        mBuilder.setContentIntent(resultPendingIntent);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            startForeground(intent1.getIntExtra("code", 1), mBuilder.build());
        }
        notificationManager.notify(notificationId, mBuilder.build());
        Intent intentCancel;
        PendingIntent pendingIntentCancel;
        AlarmManager alarmManager;

        intentCancel = new Intent(getApplicationContext(), AlarmReceiver.class);

        pendingIntentCancel = PendingIntent.getBroadcast(getApplicationContext(), intent1.getIntExtra("code",0), intentCancel, 0);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.cancel(pendingIntentCancel);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
