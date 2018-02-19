package drapps.leagueoflegendshq.models;

import io.realm.RealmObject;

/**
 * Created by Diogo on 03/06/2017.
 */

public class GlobalInfo extends RealmObject {
    private String region;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
