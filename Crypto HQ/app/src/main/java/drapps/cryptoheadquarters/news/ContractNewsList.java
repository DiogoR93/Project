package drapps.cryptoheadquarters.news;

import java.util.List;

import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.contracts.Ipresenter;

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
