package drapps.cryptoheadquarters;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.MobileAds;

import drapps.cryptoheadquarters.base.BaseCustomActivity;
import drapps.cryptoheadquarters.coinlist.CoinListFragment;
import drapps.cryptoheadquarters.news.NewsListFragment;

public class MainActivity extends BaseCustomActivity {

    AHBottomNavigation bottomNavigation;
    ViewPager viewPager;
    EditText etSearch;
    SwipeRefreshLayout swipeRefreshLayout;
    FrameLayout loadingView;
    TextView tvPageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        MobileAds.initialize(this, "ca-app-pub-7700600441093459~6942634689");

        tabsAdapter.addFragment(new CoinListFragment(), "Coins");
        tabsAdapter.addFragment(new NewsListFragment(), "News");
        tabsAdapter.addFragment(new SettingsFragment(), "Settings");
        viewPager.setAdapter(tabsAdapter);
        viewPager.setOffscreenPageLimit(tabsAdapter.getCount());


        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.coins, R.drawable.ic_timeline, R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.news, R.drawable.ic_action_news, R.color.white);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.setings, R.drawable.ic_settings, R.color.white);

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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    etSearch.setVisibility(View.VISIBLE);
                }else if (position == 1){
                    etSearch.setVisibility(View.GONE);
                    tvPageTitle.setText(getString(R.string.news));
                }else if(position == 2){
                    tvPageTitle.setText(getString(R.string.setings));
                    etSearch.setVisibility(View.GONE);
                }else{
                    tvPageTitle.setText(getString(R.string.placeholder));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
        loadingView = (FrameLayout) findViewById(R.id.loading_view);
        tvPageTitle = findViewById(R.id.txt_page_title);



    }

    public EditText getEtSearch() {
        return etSearch;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    @Override
    public void startLoading() {
        super.startLoading();
        RelativeLayout view = (RelativeLayout) getLayoutInflater().inflate(R.layout.base_custom_activity, null);
        loadingView.removeAllViews();
        Glide.with(view).load(R.drawable.loading).into((ImageView) view.findViewById(R.id.iv_loading));
        loadingView.addView(view);
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        super.stopLoading();
        loadingView.setVisibility(View.GONE);
    }

    public int getCurrentPageSelected(){
        return viewPager.getCurrentItem();
    }
}
