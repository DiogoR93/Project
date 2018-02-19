package drapps.leagueoflegendshq.models.realmobjects;

import io.realm.RealmObject;

/**
 * Created by Diogo on 09/02/2018.
 */
public class FavoriteCoin extends RealmObject{

    private String exchangeName;
    private String coinName;
    private String coinSymbol;

    public FavoriteCoin() {
    }

    public FavoriteCoin(String exchangeName, String coinName, String coinSymbol) {
        this.exchangeName = exchangeName;
        this.coinName = coinName;
        this.coinSymbol = coinSymbol;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public String getCoinName() {
        return coinName;
    }

    public String getCoinSymbol() {
        return coinSymbol;
    }
}
