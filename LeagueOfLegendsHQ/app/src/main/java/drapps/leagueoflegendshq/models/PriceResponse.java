package drapps.leagueoflegendshq.models;

/**
 * Created by Diogo on 11/02/2018.
 */
public class PriceResponse {
    SinglePriceResponse result;

    public SinglePriceResponse getResult() {
        return result;
    }

    public class SinglePriceResponse {
        String price;

        public String getPrice() {
            return price;
        }
    }
}
