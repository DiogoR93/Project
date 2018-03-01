package drapps.leagueoflegendshq;

import android.content.Context;

import java.util.Locale;

import drapps.leagueoflegendshq.models.realmobjects.Settings;
import io.realm.Realm;

/**
 * Created by diogo.rosa on 21/02/2018.
 */

public abstract class CurrencyUtils {

    public static String toSelectedCurrency(Context context, String value){
        if(Realm.getDefaultInstance().where(Settings.class).findFirst().getCurrency() == 1) {
            value = String.format(Locale.ENGLISH,"%.4f",Double.valueOf(value) / 1.22895);
            value = value.concat(" ");
            value = value.concat(context.getString(R.string.eur_symbol));
        }else{
            value = value.concat(" ");
            value = value.concat(context.getString(R.string.usd_symbol));
        }
        return value;
    }


}
