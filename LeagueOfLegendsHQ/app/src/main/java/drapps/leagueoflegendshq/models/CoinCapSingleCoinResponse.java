package drapps.leagueoflegendshq.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by diogo.rosa on 01/03/2018.
 */

public class CoinCapSingleCoinResponse {
    float totalCap;
    @SerializedName("market_cap")
    float marketCap;
    @SerializedName("price_usd")
    float priceUSD;
    @SerializedName("price_eur")
    float priceEUR;
    long volume;

    public long getVolume() {
        return volume;
    }

    public float getTotalCap() {
        return totalCap;
    }

    public float getMarketCap() {
        return marketCap;
    }

    public float getPriceUSD() {
        return priceUSD;
    }

    public float getPriceEUR() {
        return priceEUR;
    }
}
