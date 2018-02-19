package drapps.leagueoflegendshq.models;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Diogo on 04/06/2017.
 */
public class SummonerRankResponse {
    @SerializedName("")
    List<QueueRanks> queueRanksList;

    public List<QueueRanks> getQueueRanksList() {
        return queueRanksList;
    }

    public class QueueRanks extends JSONObject{
        private String queueType;
        private String tier;
        private String rank;
        private int leaguePoints;

        public String getQueueType() {
            return queueType;
        }

        public String getTier() {
            return tier;
        }

        public String getRank() {
            return rank;
        }

        public int getLeaguePoints() {
            return leaguePoints;
        }
    }
}
