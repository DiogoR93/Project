package drapps.leagueoflegendshq;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import drapps.leagueoflegendshq.adapters.ChampionSimpleAdapter;
import drapps.leagueoflegendshq.models.AllChampionsResponse;
import drapps.leagueoflegendshq.models.ChampionSimple;
import drapps.leagueoflegendshq.models.Service;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zanzy on 25/04/2017.
 */

public class ChampionListFragment extends Fragment {
    RecyclerView rvChampions;
    List<ChampionSimple> championSimples = new ArrayList<>();
    ChampionSimpleAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rv_layout,container,false);

        /*rvChampions = (RecyclerView) view.findViewById(R.id.rv_widget);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvChampions.setLayoutManager(mLayoutManager);
        adapter = new ChampionSimpleAdapter(championSimples,getActivity());
        rvChampions.setAdapter(adapter);

        Service service = Service.Factory.create();

        rx.Observable<AllChampionsResponse> observable = service.getAllChampions();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AllChampionsResponse>() {
                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(AllChampionsResponse response) {
                        JSONObject object = null;
                        // String newJsonString = response.getData().toString().replace("\"", "\\\"");

                        try {
                            object = new JSONObject(response.getData().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Iterator<String> keys = object.keys();

                        while (keys.hasNext()) {
                            // Get the key
                            String key = keys.next();
                            JSONObject value = null;
                            // Get the value
                            try {
                                value = object.getJSONObject(key);
                                ChampionSimple champ = new ChampionSimple();
                                champ.setId(value.getInt("id"));
                                champ.setName(value.getString("name"));
                                champ.setTitle(value.getString("title"));
                                JSONObject jsonImage = value.getJSONObject("image");
                                String path = "http://ddragon.leagueoflegends.com/cdn/7.11.1/img/champion/";
                                path = path.concat(jsonImage.getString("full"));
                                champ.setImage(path);
                                championSimples.add(champ);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.i("Value",championSimples.get(2).getName());


                    }
                });*/
        return view;
    }
}
