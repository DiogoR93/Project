package drapps.cryptoheadquarters.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import drapps.cryptoheadquarters.R;

/**
 * Created by diogo.rosa on 23/02/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    List<News> news = new ArrayList<>();
    Context context;
    private int lastPosition = -1;


    public NewsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_row,parent,false));
    }

    @Override
    public void onBindViewHolder(final NewsViewHolder holder, final int position) {
        try {
            Glide.with(context).load(news.get(position).getUrlToImage()).apply(RequestOptions.centerCropTransform()).into(holder.ivNews);
        }catch (Exception e){
            e.printStackTrace();
        }
        holder.title.setText(news.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, NewsDetailActivity.class)
                        .putExtra("title", news.get(position).getTitle())
                        .putExtra("description", news.get(position).getDescription())
                        .putExtra("imageUrl", news.get(position).getUrlToImage())
                        .putExtra("url", news.get(position).getUrl()));
            }
        });

        setAnimation(holder.itemView, position);
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

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView ivNews;
        TextView title;
        public NewsViewHolder(View itemView) {
            super(itemView);
            ivNews = (ImageView) itemView.findViewById(R.id.iv_news);
            title = itemView.findViewById(R.id.txt_title);
        }
    }
}
