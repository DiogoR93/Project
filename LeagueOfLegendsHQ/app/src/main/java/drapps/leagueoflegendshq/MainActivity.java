package drapps.leagueoflegendshq;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.EditText;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import drapps.leagueoflegendshq.base.BaseCustomActivity;
import drapps.leagueoflegendshq.coinlist.CoinListFragment;
import drapps.leagueoflegendshq.exchangeslist.AllListFragment;
import drapps.leagueoflegendshq.news.NewsListFragment;

public class MainActivity extends BaseCustomActivity {

    AHBottomNavigation bottomNavigation;
    ViewPager viewPager;
    EditText etSearch;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        tabsAdapter.addFragment(new CoinListFragment(), "PlayerStats");
        tabsAdapter.addFragment(new NewsListFragment(), "ChampionList");
        viewPager.setAdapter(tabsAdapter);


        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Coins", R.drawable.ic_accessible_white_24dp, R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("News", R.drawable.ic_accessible_white_24dp, R.color.white);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Current Game", R.drawable.ic_accessible_white_24dp, R.color.white);

// Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

        bottomNavigation.setAccentColor(Color.parseColor("#FFFFFF"));
        bottomNavigation.setInactiveColor(Color.parseColor("#FFFFFF"));
        bottomNavigation.setDefaultBackgroundColor(ContextCompat.getColor(this, R.color.color3));

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
        etSearch = (EditText) findViewById(R.id.et_search_coin);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);


    }

    public EditText getEtSearch() {
        return etSearch;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }
}
