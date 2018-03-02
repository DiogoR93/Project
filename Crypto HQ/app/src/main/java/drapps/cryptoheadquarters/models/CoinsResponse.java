package drapps.cryptoheadquarters.models;

import java.util.List;

import drapps.cryptoheadquarters.coinlist.Coin;

/**
 * Created by Diogo on 08/02/2018.
 */
public class CoinsResponse {
    private List<Coin> result;

    public List<Coin> getResults() {
        return result;
    }
}
