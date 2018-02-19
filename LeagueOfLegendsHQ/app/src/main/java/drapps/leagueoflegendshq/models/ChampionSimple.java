package drapps.leagueoflegendshq.models;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by zanzy on 20/04/2017.
 */

public class ChampionSimple extends RealmObject {
    private String title;
    private String Name;
    private int id;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
