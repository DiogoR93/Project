package drapps.leagueoflegendshq.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import drapps.leagueoflegendshq.R;

/**
 * Created by diogo.rosa on 23/02/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    List<News> news = new ArrayList<>();
    Context context;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_row,parent,false));
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        try {
            Picasso.with(context).load(news.get(position).getUrlToImage()).centerCrop().resize(holder.ivNews.getWidth(), holder.ivNews.getHeight()).into(holder.ivNews);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void swapContent(List<News> news){
        this.news.clear();
        this.news.addAll(news);
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView ivNews;
        TextView title;
        public NewsViewHolder(View itemView) {
            super(itemView);
            ivNews = (ImageView) itemView.findViewById(R.id.iv_news);
        }
    }
}
