package drapps.leagueoflegendshq.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import drapps.leagueoflegendshq.CurrencyUtils;
import drapps.leagueoflegendshq.R;
import drapps.leagueoflegendshq.models.CoinCapResponse;
import drapps.leagueoflegendshq.models.CoinsResponse;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Diogo on 07/02/2018.
 */
public class CoinAdaper extends RecyclerView.Adapter<CoinAdaper.CoinVH>{

    public Context context;
    List<CoinCapResponse> listFiltered = new ArrayList<>();
    List<CoinCapResponse> list = new ArrayList<>();
    PublishSubject<CoinCapResponse> publishSubject = PublishSubject.create();

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
            holder.txtName.setText(listFiltered.get(position).getName()+ " ("+ listFiltered.get(position).getSymbol() + ")");
            holder.txtChangeCap.setText(listFiltered.get(position).getChangePercentage());
            if(listFiltered.get(position).getChangePercentage().contains("-")){
                holder.txtChangeCap.setTextColor(ContextCompat.getColor(context, R.color.negative_red));
            }else{
                holder.txtChangeCap.setTextColor(ContextCompat.getColor(context, R.color.positive_green));
            }
            holder.txtValue.setText(CurrencyUtils.toSelectedCurrency(listFiltered.get(position).getPrice()));

            try {
                Picasso.with(context).load(context.getResources().getIdentifier(listFiltered.get(position).getSymbol().toLowerCase(), "drawable", context.getPackageName())).fit().into(holder.ivIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    publishSubject.onNext(listFiltered.get(position));
                }
            });
    }

    public class CoinVH extends RecyclerView.ViewHolder{

        public TextView txtName;
        TextView txtChangeCap;
        public ImageView ivIcon;
        TextView txtValue;

        public CoinVH(View itemView) {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_coin);
            txtName = (TextView) itemView.findViewById(R.id.txt_coin_name);
            txtChangeCap = (TextView) itemView.findViewById(R.id.txt_coin_change);
            txtValue = (TextView) itemView.findViewById(R.id.txt_coin_price);
        }
    }

    public void swapContent(List<CoinCapResponse> list){
        this.listFiltered.clear();
        this.list.clear();
        this.listFiltered.addAll(list);
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void applyFilter(String filter){
        this.listFiltered.clear();
        if(filter.equals("")){
            listFiltered.addAll(list);
        }else {
            for (CoinCapResponse cr : list) {
                if(cr.getName().toLowerCase().contains(filter.toLowerCase()) || cr.getSymbol().toLowerCase().contains(filter.toLowerCase())){
                    listFiltered.add(cr);
                }
            }
        }
        notifyDataSetChanged();
    }

    public Observable<CoinCapResponse> getPublishSubject() {
        return publishSubject.asObservable();
    }

    @Override
    public int getItemCount() {
        return listFiltered.size();
    }
}
