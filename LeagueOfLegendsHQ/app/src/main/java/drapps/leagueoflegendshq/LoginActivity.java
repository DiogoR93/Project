package drapps.leagueoflegendshq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import drapps.leagueoflegendshq.models.GlobalInfo;
import drapps.leagueoflegendshq.models.Service;
import drapps.leagueoflegendshq.models.SummonerInfo;
import io.realm.Realm;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName;
    EditText etRegion;
    Button btnLogin;
    MainApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(Realm.getDefaultInstance().where(SummonerInfo.class).findFirst() != null){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }

        etUserName = (EditText) findViewById(R.id.et_username);
        etRegion = (EditText) findViewById(R.id.et_region);
        btnLogin = (Button) findViewById(R.id.btn_login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etUserName.getText().toString().equals("") && !etRegion.getText().toString().equals("")){
                    checkUser(etUserName.getText().toString(),etRegion.getText().toString());
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        application = MainApplication.get(this);

    }

    private void checkUser(String username, String region) {
        Service service = application.getService();

       /* rx.Observable<SummonerInfo> observable = service.getSummonerInfo(region, username);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SummonerInfo>() {
                    @Override
                    public void onCompleted() {
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(SummonerInfo response) {
                        Toast.makeText(getApplicationContext(),"id: "+response.getId(),Toast.LENGTH_LONG).show();
                        Realm.getDefaultInstance().beginTransaction();
                        Realm.getDefaultInstance().delete(SummonerInfo.class);
                        Realm.getDefaultInstance().insert(response);
                        GlobalInfo globalInfo = new GlobalInfo();
                        globalInfo.setRegion("euw");
                        Realm.getDefaultInstance().insert(globalInfo);

                        Realm.getDefaultInstance().commitTransaction();
                        }
                });*/

    }
}
