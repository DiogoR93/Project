package drapps.leagueoflegendshq.adapters;

/**
 * Created by zanzy on 23/04/2017.
 */

import java.util.List;

import android.content.Context;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import drapps.leagueoflegendshq.R;
import drapps.leagueoflegendshq.models.ChampionSimple;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by zanzy on 18/08/2016.
 */
public class ChampionSimpleAdapter extends RecyclerView.Adapter<ChampionSimpleAdapter.ViewHolder>  {

    private List<ChampionSimple> clinicList;
    Context context;

    private final PublishSubject<ChampionSimple> onClickSubjectReturnClinic = PublishSubject.create();

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView img;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img_champion);
            title = (TextView) view.findViewById(R.id.tv_champion_name);

        }
    }

    public ChampionSimpleAdapter(List<ChampionSimple> clinicList, Context context) {
        this.clinicList = clinicList;this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.champion_list_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChampionSimpleAdapter.ViewHolder holder, int position) {
        Picasso.with(context).load(clinicList.get(position).getImage()).into(holder.img);
        holder.title.setText(clinicList.get(position).getName());
    }

    public Observable<ChampionSimple> getObservableClinic(){
        return onClickSubjectReturnClinic.asObservable();
    }

    @Override
    public int getItemCount() {
        return clinicList.size();
    }

}

