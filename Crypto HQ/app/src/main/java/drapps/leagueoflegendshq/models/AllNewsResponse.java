package drapps.leagueoflegendshq.models;

import java.util.List;

import drapps.leagueoflegendshq.news.News;

/**
 * Created by diogo.rosa on 23/02/2018.
 */

public class AllNewsResponse {
    public List<News> articles;

    public List<News> getArticles() {
        return articles;
    }
}
