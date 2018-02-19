package drapps.leagueoflegendshq.exchangeslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import drapps.leagueoflegendshq.R;
import drapps.leagueoflegendshq.models.Exchange;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Diogo on 07/02/2018.
 */
public class ExchangeAdaper extends RecyclerView.Adapter<ExchangeAdaper.ExchangeVH>{

    public Context context;
    List<Exchange> list = new ArrayList<>();
    PublishSubject<Exchange> publishSubject = PublishSubject.create();

    public ExchangeAdaper(Context context) {
        this.context = context;
    }

    @Override
    public ExchangeVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_exchange, parent, false);
        return new ExchangeVH(view);
    }

    @Override
    public void onBindViewHolder(ExchangeVH holder, final int position) {
            holder.txtName.setText(list.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    publishSubject.onNext(list.get(position));
                }
            });
    }

    public class ExchangeVH extends RecyclerView.ViewHolder{

        public TextView txtName;

        public ExchangeVH(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_exchange_name);
        }
    }

    public void swapContent(List<Exchange> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public Observable<Exchange> getPublishSubject() {
        return publishSubject.asObservable();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
