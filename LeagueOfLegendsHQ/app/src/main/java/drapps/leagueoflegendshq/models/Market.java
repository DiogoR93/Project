package drapps.leagueoflegendshq.models;

/**
 * Created by Diogo on 03/02/2018.
 */
public class Market {
    private String pair;
    private String route;
    private boolean active;

    public Market(String pair, String route, boolean active) {
        this.pair = pair;
        this.route = route;
        this.active = active;
    }

    public String getPair() {
        return pair;
    }

    public String getRoute() {
        return route;
    }

    public boolean isActive() {
        return active;
    }
}
