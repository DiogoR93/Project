package drapps.leagueoflegendshq.news;

import java.util.List;

import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.contracts.Ipresenter;

/**
 * Created by diogo.rosa on 23/02/2018.
 */

public interface ContractNewsList {
    interface View extends IView{
        void onNewsLoaded(List<News> list);
    }
    interface Presenter extends Ipresenter{
        void loadNews();
    }
}
