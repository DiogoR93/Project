package drapps.cryptoheadquarters.news;

import android.content.Context;
import android.util.Log;

import java.util.Locale;

import drapps.cryptoheadquarters.base.BasePresenter;
import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.models.AllNewsResponse;
import drapps.cryptoheadquarters.models.Service;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by diogo.rosa on 23/02/2018.
 */

public class NewsListPresenter extends BasePresenter implements ContractNewsList.Presenter{

    NewsListFragment fragment;
    Service serviceApi;

    public NewsListPresenter(Context context) {
        super(context);
        serviceApi = getServiceAPI();
    }

    @Override
    public void attach(IView view) {
        fragment = ((NewsListFragment) view);
    }

    @Override
    public void dettach() {

    }

    @Override
    public void loadNews() {
        String localeLanguage = Locale.getDefault().getLanguage();
        if(localeLanguage.equals("pt") || localeLanguage.equals("ar") || localeLanguage.equals("es") || localeLanguage.equals("it") || localeLanguage.equals("de")
        || localeLanguage.equals("he") || localeLanguage.equals("nl") || localeLanguage.equals("no") || localeLanguage.equals("ru")||localeLanguage.equals("se")
        || localeLanguage.equals("ud")||localeLanguage.equals("zh")){
            localeLanguage = Locale.getDefault().getLanguage();
        }else{
            localeLanguage = "en";
        }
        rx.Observable<AllNewsResponse> observable = serviceApi.getAllNews(localeLanguage);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AllNewsResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(AllNewsResponse response) {
                        fragment.onNewsLoaded(response.getArticles());
                        Log.i("News1", response.getArticles().get(0).getTitle());
                    }
                });
    }
}
