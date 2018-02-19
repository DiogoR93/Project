package drapps.leagueoflegendshq.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

import drapps.leagueoflegendshq.adapters.TabsAdapter;
import io.realm.Realm;

/**
 * Created by Diogo on 02/02/2018.
 */
public abstract class BaseCustomActivity extends AppCompatActivity {
    public TabsAdapter tabsAdapter;
    Realm realm;
    public FragmentTransaction transaction;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        realm = Realm.getDefaultInstance();

    }

    public abstract void  bindViews();

    @Override
    protected void onResume() {
        super.onResume();

    }
}
