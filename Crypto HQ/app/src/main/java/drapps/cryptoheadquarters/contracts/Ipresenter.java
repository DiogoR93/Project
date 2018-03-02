package drapps.cryptoheadquarters.contracts;

/**
 * Created by Diogo on 03/02/2018.
 */
public interface Ipresenter {
    void attach(IView view);
    void dettach();
}
