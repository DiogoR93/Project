package drapps.leagueoflegendshq.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diogo on 12/02/2018.
 */
public class CoinCapResponse {

    @SerializedName("cap24hrChange")
    private String changePercentage;
    @SerializedName("long")
    String name;
    @SerializedName("short")
    String symbol;

    String supply;
    String volume;
    String price;

    public String getPrice() {
        return price;
    }

    public String getSupply() {
        return supply;
    }

    public String getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getChangePercentage() {
        return changePercentage;
    }
}
