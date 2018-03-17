package drapps.cryptoheadquarters;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import drapps.cryptoheadquarters.base.BaseCustomActivity;

/**
 * Created by diogo.rosa on 13/03/2018.
 */

public class AlarmsActivity extends BaseCustomActivity {
    Button btn;
    Button btn2;
    EditText etPrice;
    boolean isAbove = false;
    Intent intent;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    Button btnDone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms);
        btn = findViewById(R.id.btn_below);
        btn2 = findViewById(R.id.btn_above);
        etPrice = findViewById(R.id.et_price);
        btnDone = findViewById(R.id.btn_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    isAbove = false;

                }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    isAbove = true;
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etPrice.getText().toString().length() > 0) {
                    createAlarm();
                }
            }
        });

    }

    @Override
    public void bindViews() {

    }

    public void createAlarm(){
                  Toast.makeText(AlarmsActivity.this, "ALARM IS ON", Toast.LENGTH_SHORT).show();

                                      /*if(Build.VERSION.SDK_INT >= 23) {
                                          calendar.set(Calendar.HOUR_OF_DAY, getT;
                                          calendar.set(Calendar.MINUTE, alarmTimePicker.getMinute());
                                      }else {
                                          calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
                                          calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
                                      }*/
                                      int requestCode =(int) (Math.random()*1000000);
                                      intent = new Intent(AlarmsActivity.this, AlarmReceiver.class)
                                              .putExtra("price", Double.valueOf(etPrice.getText().toString()))
                                              .putExtra("code", requestCode)
                                              .putExtra("coin",getIntent().getStringExtra("coin"))
                                              .putExtra("above", isAbove);
                                      pendingIntent = PendingIntent.getBroadcast(AlarmsActivity.this, requestCode, intent, 0);
                                      alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                                      alarmManager.setRepeating(AlarmManager.RTC_WAKEUP
                                              , System.currentTimeMillis(), 1000 * 60 , pendingIntent);
                                      finish();

    }
}
