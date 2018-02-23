package drapps.leagueoflegendshq.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import drapps.leagueoflegendshq.R;
import drapps.leagueoflegendshq.base.BaseCustomFragment;

/**
 * Created by diogo.rosa on 22/02/2018.
 */

public class NewsListFragment extends BaseCustomFragment implements ContractNewsList.View{

    RecyclerView rvNews;
    NewsAdapter adapter;
    NewsListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rv_layout, container, false);
        bindViews(view);
        setupPresenter();
        return view;
    }



    @Override
    public void bindViews(View view) {
        rvNews = (RecyclerView) view.findViewById(R.id.rv_widget);
        adapter = new NewsAdapter(getContext());
        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNews.setAdapter(adapter);
    }

    @Override
    public void setupPresenter() {
        presenter = new NewsListPresenter(getContext());
        presenter.attach(this);
        presenter.loadNews();
    }

    @Override
    public void onNewsLoaded(List<News> list) {
        adapter.swapContent(list);
    }
}
