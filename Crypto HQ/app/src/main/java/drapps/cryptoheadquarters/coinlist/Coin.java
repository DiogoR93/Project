package drapps.cryptoheadquarters.coinlist;

import io.realm.RealmObject;

/**
 * Created by Diogo on 07/02/2018.
 */
public class Coin extends RealmObject{
    private boolean fiat;
    private String name;
    private String symbol;
    private String route;

    public Coin(boolean isFiat, String name, String symbol, String route) {
        this.fiat = isFiat;
        this.name = name;
        this.symbol = symbol;
        this.route = route;
    }

    public Coin() {
    }

    public boolean isFiat() {
        return fiat;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRoute() {
        return route;
    }
}
