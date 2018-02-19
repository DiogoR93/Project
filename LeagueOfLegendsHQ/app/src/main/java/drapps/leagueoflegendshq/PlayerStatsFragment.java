package drapps.leagueoflegendshq;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import drapps.leagueoflegendshq.models.AllStatsRankedResponse;
import drapps.leagueoflegendshq.models.ChampionRankedStats;
import drapps.leagueoflegendshq.models.GlobalInfo;
import drapps.leagueoflegendshq.models.Service;
import drapps.leagueoflegendshq.models.SummonerInfo;
import drapps.leagueoflegendshq.models.SummonerRankResponse;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zanzy on 25/04/2017.
 */

public class PlayerStatsFragment extends Fragment {

    MainApplication application;
    Service service;
    Realm realm;

    ImageView ivTier;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_stats,container,false);

        ivTier = (ImageView) view.findViewById(R.id.iv_tier_icon);

        application = MainApplication.get(getContext());
        service = application.getService();
        realm = Realm.getDefaultInstance();
        //fetchRankedStats();
        fetchSummonerRank();

        return view;
    }

    private void fetchSummonerRank() {
        //Service service = application.getService();

       /* rx.Observable<List<SummonerRankResponse.QueueRanks>> observable = service.getSummonerRank("euw1", realm.where(SummonerInfo.class).findFirst().getId());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<SummonerRankResponse.QueueRanks>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<SummonerRankResponse.QueueRanks> response) {
                        SummonerRankResponse.QueueRanks qrSoloRank = null;
                        Log.i("response", response.get(0).toString());
                        *//*for (SummonerRankResponse.QueueRanks qr:response.getQueueRanksList()
                             ) {
                            if(qr.getQueueType().equals("RANKED_SOLO_5x5")){
                                qrSoloRank = qr;
                            }

                        }*//*
                        *//*if(qrSoloRank != null) {
                            realm.beginTransaction();
                            realm.where(SummonerInfo.class).findFirst().setLeaguePoints(qrSoloRank.getLeaguePoints());
                            realm.where(SummonerInfo.class).findFirst().setRank(qrSoloRank.getRank());
                            realm.where(SummonerInfo.class).findFirst().setTier(qrSoloRank.getTier());
                            Realm.getDefaultInstance().commitTransaction();
                        }*//*
                    }
                });
*/


       /* Call<List<SummonerRankResponse.QueueRanks>> call = service.getSummonerRank("euw1",realm.where(SummonerInfo.class).findFirst().getId());
        call.enqueue(new Callback<List<SummonerRankResponse.QueueRanks>>() {

            @Override
            public void onResponse(Call<List<SummonerRankResponse.QueueRanks>> call, Response<List<SummonerRankResponse.QueueRanks>> response) {
                SummonerRankResponse.QueueRanks qrSoloRank = null;
                Log.e("MainActivity", response.body().get(0).getQueueType().toString());
                for (SummonerRankResponse.QueueRanks qr:response.body()
                     ) {
                    if(qr.getQueueType().equals("RANKED_SOLO_5x5")) {
                        qrSoloRank = qr;
                    }

                }
                if(qrSoloRank != null) {
                    realm.beginTransaction();
                    realm.where(SummonerInfo.class).findFirst().setLeaguePoints(qrSoloRank.getLeaguePoints());
                    realm.where(SummonerInfo.class).findFirst().setRank(qrSoloRank.getRank());
                    realm.where(SummonerInfo.class).findFirst().setTier(qrSoloRank.getTier());
                    Realm.getDefaultInstance().commitTransaction();
                }
            }

            @Override
            public void onFailure(Call<List<SummonerRankResponse.QueueRanks>> call, Throwable t) {
                Log.e("MainActivity", t.toString());
            }
        });
    }
*/

 /*   //Services
    public void fetchRankedStats() {

        rx.Observable<AllStatsRankedResponse> observable = service.getRankedStats(realm.where(GlobalInfo.class).findFirst().getRegion(),realm.where(SummonerInfo.class).findFirst().getId());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AllStatsRankedResponse>() {
                    @Override
                    public void onCompleted() {
                        fillStats();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(AllStatsRankedResponse response) {
                        realm.beginTransaction();
                        realm.delete(ChampionRankedStats.class);
                        realm.commitTransaction();
                        JSONArray championsList = null;
                        // String newJsonString = response.getData().toString().replace("\"", "\\\"");

                        try {
                            championsList = new JSONArray(response.getData().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONObject championElement = null;
                        int id = 0;
                        JSONObject championElementStats = null;
                        for(int i = 0; i < championsList.length();i++){
                            try {
                                championElement = championsList.getJSONObject(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            if(championElement != null) {
                                try {
                                    id = championElement.getInt("id");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                try {
                                    championElementStats = championElement.getJSONObject("stats");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                ChampionRankedStats stats = new ChampionRankedStats();
                                stats.setId(id);

                                try {
                                    stats.setTotalSessionsPlayed(championElementStats.getInt("totalSessionsPlayed"));
                                    stats.setTotalSessionsWon(championElementStats.getInt("totalSessionsWon"));
                                    stats.setTotalSessionsLost(championElementStats.getInt("totalSessionsLost"));
                                    stats.setTotalChampionKills(championElementStats.getInt("totalChampionKills"));
                                    stats.setTotalDamageDealt(championElementStats.getInt("totalDamageDealt"));
                                    stats.setTotalDamageTaken(championElementStats.getInt("totalDamageTaken"));
                                    stats.setMostChampionKillsPerSession(championElementStats.getInt("mostChampionKillsPerSession"));
                                    stats.setTotalMinionKills(championElementStats.getInt("totalMinionKills"));
                                    stats.setTotalDoubleKills(championElementStats.getInt("totalDoubleKills"));
                                    stats.setTotalTripleKills(championElementStats.getInt("totalTripleKills"));
                                    stats.setTotalQuadraKills(championElementStats.getInt("totalQuadraKills"));
                                    stats.setTotalPentaKills(championElementStats.getInt("totalPentaKills"));
                                    stats.setTotalDeathsPerSession(championElementStats.getInt("totalDeathsPerSession"));
                                    stats.setTotalGoldEarned(championElementStats.getInt("totalGoldEarned"));
                                    stats.setTotalTurretsKilled(championElementStats.getInt("totalTurretsKilled"));
                                    stats.setTotalPhysicalDamageDealt(championElementStats.getInt("totalPhysicalDamageDealt"));
                                    stats.setTotalMagicDamageDealt(championElementStats.getInt("totalMagicDamageDealt"));
                                    stats.setTotalAssists(championElementStats.getInt("totalAssists"));
                                    stats.setMaxChampionsKilled(championElementStats.getInt("maxChampionsKilled"));
                                    stats.setMaxNumDeaths(championElementStats.getInt("maxNumDeaths"));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                realm.beginTransaction();
                                realm.insert(stats);
                                realm.commitTransaction();
                            }

                        }





                    }
                });

    }*/

    /*private void fillStats() {
        if(realm.where(SummonerInfo.class).findFirst().getTier().equals("SILVER")){
            ivTier.setImageResource(R.drawable.ic_silver_tier);
        }
    }*/
    }}
