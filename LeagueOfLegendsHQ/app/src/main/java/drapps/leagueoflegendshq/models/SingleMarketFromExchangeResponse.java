package drapps.leagueoflegendshq.models;

/**
 * Author: Diogo
 */
public class SingleMarketFromExchangeResponse {
    public String pair;
    public String route;
    public boolean active;

    public boolean isActive() {
        return active;
    }

    public String getRoute() {
        return route;
    }

    public String getPair() {
        return pair;
    }
}