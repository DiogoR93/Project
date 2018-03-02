package drapps.cryptoheadquarters.exchangeslist.contracts;

import java.util.List;

import drapps.cryptoheadquarters.contracts.IView;
import drapps.cryptoheadquarters.contracts.Ipresenter;
import drapps.cryptoheadquarters.models.Exchange;

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
