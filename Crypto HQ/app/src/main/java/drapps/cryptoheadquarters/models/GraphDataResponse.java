package drapps.cryptoheadquarters.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by diogo.rosa on 26/02/2018.
 */

public class GraphDataResponse {
    List<double[]> price;
    @SerializedName("market_cap")
    List<double[]> marketCap;
    List<double[]> volume;

    public List<double[]> getMarketCap() {
        return marketCap;
    }

    public List<double[]> getVolume() {
        return volume;
    }

    public List<double[]> getPrice() {
        return price;
    }
}
