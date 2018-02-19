package drapps.leagueoflegendshq;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import drapps.leagueoflegendshq.base.BaseCustomFragment;
import drapps.leagueoflegendshq.coinlist.Coin;
import drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin;

/**
 * Created by Diogo on 07/02/2018.
 */
public class YourCoinsFragment extends BaseCustomFragment implements ContractYourCoins.View {

    Button btnAdCoin;
    YourCoinsPresenter presenter;
    RecyclerView rvFavCoins;
    FavoriteCoinsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_your_coins, container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void bindViews(View view) {
        btnAdCoin = (Button) view.findViewById(R.id.btn_add_coin);
        rvFavCoins = (RecyclerView) view.findViewById(R.id.rv_fav_coins);

        rvFavCoins.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new FavoriteCoinsAdapter(getContext(), ((MainApplication) getActivity().getApplicationContext()).getService());
        rvFavCoins.setAdapter(adapter);

        btnAdCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MarketListActivity.class));
            }
        });
    }

    @Override
    public void onLoadedFavoriteCoins(List<Coin> coins) {

    }

    @Override
    public void setupPresenter() {
        presenter = new YourCoinsPresenter(getContext());
        presenter.attach(this);
    }
}
