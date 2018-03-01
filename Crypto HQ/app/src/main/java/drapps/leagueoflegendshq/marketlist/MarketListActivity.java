package drapps.leagueoflegendshq.marketlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import drapps.leagueoflegendshq.R;
import drapps.leagueoflegendshq.base.BaseCustomActivity;
import drapps.leagueoflegendshq.base.BaseCustomFragment;
import drapps.leagueoflegendshq.exchangeslist.AllListFragment;

/**
 * Created by Diogo on 03/02/2018.
 */

public class MarketListActivity extends BaseCustomActivity {

    FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standart_layout);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, new AllListFragment()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void bindViews() {
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
    }

    public void replaceFragment(BaseCustomFragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }
}
