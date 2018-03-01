package drapps.leagueoflegendshq;

import android.app.Application;
import android.content.Context;

import drapps.leagueoflegendshq.models.Service;
import drapps.leagueoflegendshq.models.realmobjects.Settings;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by zanzy on 20/04/2017.
 */

public class MainApplication extends Application {

    private Service service;


    public Service getService() {
        if(service == null);
            service = Service.Factory.create();
        return service;
    }

    public static MainApplication get(Context context) {

        return (MainApplication) context.getApplicationContext();
    }
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);

        if(Realm.getDefaultInstance().where(Settings.class).findAll().isEmpty()){
            Realm.getDefaultInstance().beginTransaction();
            Realm.getDefaultInstance().insertOrUpdate(new Settings(0)); //usd
            Realm.getDefaultInstance().commitTransaction();
        }

        service = Service.Factory.create();


    }
}