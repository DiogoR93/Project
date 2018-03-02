package drapps.cryptoheadquarters.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import drapps.cryptoheadquarters.R;
import drapps.cryptoheadquarters.models.Service;
import drapps.cryptoheadquarters.models.realmobjects.FavoriteCoin;
import io.realm.Realm;

/**
 * Created by Diogo on 11/02/2018.
 */
public class FavoriteCoinsAdapter extends RecyclerView.Adapter<FavoriteCoinsAdapter.FavCoinViewHolder>{

    List<FavoriteCoin> list = new ArrayList<>();
    Context context;
    Service service;

    public FavoriteCoinsAdapter(Context context, Service service) {
        this.context = context;
        this.service = service;
        list.addAll(Realm.getDefaultInstance().where(FavoriteCoin.class).findAll());
    }

    @Override
    public FavCoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_fav_coin, parent, false);


        return new FavCoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavCoinViewHolder holder, int position) {
        holder.txtName.setText(list.get(position).getCoinName());
        //requestPrice(listFiltered.get(position), holder);
    }

    /*private void requestPrice(FavoriteCoin favoriteCoin, final FavCoinViewHolder holder) {
        rx.Observable<PriceAverageResponse> observable = service.getPrice(favoriteCoin.getCoinSymbol().toUpperCase());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PriceAverageResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(PriceAverageResponse response) {
                        Log.i("COIN", response.getChangePercentage());
                        holder.txtPrice.setText(response.getChangePercentage());
                    }
                });
    }*/

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FavCoinViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtPrice;

        public FavCoinViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.txt_coin_name);
            txtPrice = (TextView) itemView.findViewById(R.id.txt_coin_price);
        }
    }
}
