package drapps.cryptoheadquarters.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Diogo on 03/02/2018.
 */
public class ExchangesResponse {
    @SerializedName("result")
    public List<SingleExchangeResponse> result;

    public List<SingleExchangeResponse> getResult() {
        return result;
    }
}
