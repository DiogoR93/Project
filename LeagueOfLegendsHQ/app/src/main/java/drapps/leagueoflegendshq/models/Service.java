package drapps.leagueoflegendshq.models;


import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by zanzy on 18/04/2017.
 */

public interface Service {

    String mUrl = "https://api.cryptowat.ch";

    @GET("/markets/{exchange}/{crypto}")
    rx.Observable<MarketResponse> getSpecificMarketExchange(@Path("exchange") String exchange,@Path("crypto") String crypto);

    @GET("http://coincap.io/front")
    rx.Observable<List<CoinCapResponse>> getCoinsFromCoinCap();

    @GET
    rx.Observable<GeneralResponse> getGeneralInfo(@Url String url);

    @GET("/exchanges")
    rx.Observable<ExchangesResponse> getALlExchanges();

    @GET("/markets/{exchange}")
    rx.Observable<MarketsFromExchangeResponse> getMarketsFromExchange(@Path("exchange") String exchange);

    @GET("/assets")
    rx.Observable<CoinsResponse> getCoins();

    @GET("https://newsapi.org/v2/everything?q=cryptocurrency&sortBy=publishedAt&pageSize=100&apiKey=0be764398a584ebab12a153b1e810052")
    rx.Observable<AllNewsResponse> getAllNews();

    @GET("http://coincap.io/history/1day/{coinName}")
    rx.Observable<GraphDataResponse> getGraphData(@Path("coinName") String coinName);

    @GET("http://coincap.io/page/{coin}")
    rx.Observable<CoinCapSingleCoinResponse> getCoinInfo(@Path("coin") String coin);



    class Factory {

        private static Retrofit retrofit;

        public static Service create() {

            //TODO: in prod, remove this
            // Beautiful login interceptor to debug what is being RESTly sent
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            //TODO add language/hash to all post requests
//            httpClient.addInterceptor(new Interceptor() {
//                @Override
//                public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
//                    Request request = chain.request();
//
//                    FormBody.Builder builder = new FormBody.Builder();
////                    builder.add("hash", "");
//                    builder.add("language", Locale.getDefault().getCountry());
//
//                    request = request.newBuilder().post(builder.build()).build();
//                    return chain.proceed(request);
//
//                }
//            });

            //Retrofit initialization, for REST api calls
            retrofit = new Retrofit.Builder()
                    .baseUrl(mUrl)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            return retrofit.create(Service.class);
        }

        public static Retrofit getRetrofit() {
            return Factory.retrofit;
        }
    }
}
