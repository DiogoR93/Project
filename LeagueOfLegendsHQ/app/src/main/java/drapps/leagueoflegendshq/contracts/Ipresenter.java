package drapps.leagueoflegendshq.contracts;

import android.view.View;

/**
 * Created by Diogo on 03/02/2018.
 */
public interface Ipresenter {
    void attach(IView view);
    void dettach();
}
