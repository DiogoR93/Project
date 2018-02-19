package drapps.leagueoflegendshq.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by Diogo on 03/06/2017.
 */
public class AllStatsRankedResponse {
    JsonArray champions;

    public JsonArray getData() {
        return champions;
    }
}
