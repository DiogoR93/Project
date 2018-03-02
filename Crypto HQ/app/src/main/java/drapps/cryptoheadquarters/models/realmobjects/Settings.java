package drapps.cryptoheadquarters.models.realmobjects;

import io.realm.RealmObject;

/**
 * Created by diogo.rosa on 25/02/2018.
 */

public class Settings extends RealmObject {
    int currency;


    public Settings(int currency) {
        this.currency = currency;
    }

    public Settings() {
    }

    public int getCurrency() {
        return currency;
    }
}
