package drapps.leagueoflegendshq;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import drapps.leagueoflegendshq.base.BaseCustomActivity;
import drapps.leagueoflegendshq.exchangeslist.AllListFragment;

public class MainActivity extends BaseCustomActivity {

    AHBottomNavigation bottomNavigation;
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        tabsAdapter.addFragment(new YourCoinsFragment(), "PlayerStats");
        tabsAdapter.addFragment(new ChampionListFragment(), "ChampionList");
        viewPager.setAdapter(tabsAdapter);


        AHBottomNavigationItem item1 = new AHBottomNavigationItem("News", R.drawable.ic_accessible_white_24dp, R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Champs", R.drawable.ic_accessible_white_24dp, R.color.white);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Current Game", R.drawable.ic_accessible_white_24dp, R.color.white);

// Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

        bottomNavigation.setAccentColor(Color.parseColor("#FFFFFF"));
        bottomNavigation.setInactiveColor(Color.parseColor("#FFFFFF"));
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#273E47"));

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                viewPager.setCurrentItem(position);
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void bindViews() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
    }
}
