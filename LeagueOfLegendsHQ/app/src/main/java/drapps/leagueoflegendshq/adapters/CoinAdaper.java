package drapps.leagueoflegendshq.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import drapps.leagueoflegendshq.R;
import drapps.leagueoflegendshq.coinlist.Coin;
import drapps.leagueoflegendshq.models.Exchange;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Diogo on 07/02/2018.
 */
public class CoinAdaper extends RecyclerView.Adapter<CoinAdaper.CoinVH>{

    public Context context;
    List<Coin> list = new ArrayList<>();
    PublishSubject<Coin> publishSubject = PublishSubject.create();

    public CoinAdaper(Context context) {
        this.context = context;
    }

    @Override
    public CoinVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_coin, parent, false);
        return new CoinVH(view);
    }

    @Override
    public void onBindViewHolder(CoinVH holder, final int position) {
        if(!list.get(position).isFiat()) {
            holder.txtName.setText(list.get(position).getName());
            try {
                Picasso.with(context).load(context.getResources().getIdentifier(list.get(position).getSymbol().toLowerCase(), "drawable", context.getPackageName())).fit().into(holder.ivIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    publishSubject.onNext(list.get(position));
                }
            });
        }else{
            holder.itemView.setVisibility(View.GONE);
        }
    }

    public class CoinVH extends RecyclerView.ViewHolder{

        public TextView txtName;
        public ImageView ivIcon;

        public CoinVH(View itemView) {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_coin);
            txtName = (TextView) itemView.findViewById(R.id.txt_coin_name);
        }
    }

    public void swapContent(List<Coin> list){
        this.list.clear();
        for(Coin coin : list){
            if(!coin.isFiat())
                this.list.add(coin);
        }
        notifyDataSetChanged();
    }

    public Observable<Coin> getPublishSubject() {
        return publishSubject.asObservable();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
