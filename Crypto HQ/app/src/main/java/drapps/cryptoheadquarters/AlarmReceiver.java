package drapps.cryptoheadquarters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

/**
 * Created by Shaon on 4/10/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, AlarmService.class)
                .putExtra("price", intent.getDoubleExtra("price", 0))
                .putExtra("code", intent.getIntExtra("code",0))
                .putExtra("above", intent.getBooleanExtra("above",false))
                .putExtra("coin", intent.getStringExtra("coin"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                context.startForegroundService(intent1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            context.startService(intent1);
        }

    }
}
