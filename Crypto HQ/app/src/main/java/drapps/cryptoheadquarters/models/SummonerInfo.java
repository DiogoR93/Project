package drapps.cryptoheadquarters.models;

import io.realm.RealmObject;

/**
 * Created by Diogo on 03/06/2017.
 */
public class SummonerInfo extends RealmObject {
    private int id;
    private int profileIconId;

    private String queueType;
    private String tier;
    private String rank;
    private int leaguePoints;

    public void setId(int id) {
        this.id = id;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public int getId() {
        return id;
    }

    public int getProfileIconId() {
        return profileIconId;
    }
}
