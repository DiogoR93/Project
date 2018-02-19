package drapps.leagueoflegendshq.exchangeslist.contracts;

import java.util.List;

import drapps.leagueoflegendshq.contracts.IView;
import drapps.leagueoflegendshq.contracts.Ipresenter;
import drapps.leagueoflegendshq.models.Exchange;

/**
 * Created by Diogo on 03/02/2018.
 */

public interface ContractAllListMain {
    interface View extends IView {
        void onExchangesRequested(List<Exchange> list);
    }
    interface Presenter extends Ipresenter {
        void requestExchanges();
    }
}
