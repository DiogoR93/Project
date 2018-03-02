package drapps.cryptoheadquarters.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diogo on 03/02/2018.
 */
public class SingleExchangeResponse {
    @SerializedName("name")
    public String name;
    @SerializedName("route")
    public String route;
    @SerializedName("active")
    public String active;

    public String symbol;

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public String getActive() {
        return active;
    }
}
