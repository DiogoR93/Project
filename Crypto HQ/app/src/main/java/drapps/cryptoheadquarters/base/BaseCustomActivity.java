package drapps.cryptoheadquarters.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import drapps.cryptoheadquarters.adapters.TabsAdapter;
import io.realm.Realm;

/**
 * Created by Diogo on 02/02/2018.
 */
public abstract class BaseCustomActivity extends AppCompatActivity {
    public TabsAdapter tabsAdapter;
    Realm realm;
    public FragmentTransaction transaction;
    View view;


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

    public void startLoading(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public void stopLoading(){
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }
}
