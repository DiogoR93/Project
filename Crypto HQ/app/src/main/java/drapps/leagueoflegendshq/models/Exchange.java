package drapps.leagueoflegendshq.models;

/**
 * Created by Diogo on 03/02/2018.
 */
public class Exchange {
    public String name;
    public String route;
    public String symbol;

    public Exchange(String name, String route) {
        this.route = route;
        this.name = name;
    }

    public Exchange(String name, String route, String symbol) {
        this.route = route;
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public String getSymbol() {
        return symbol;
    }
}
