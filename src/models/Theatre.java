package models;

import java.util.List;

public class Theatre {

    private final String id;
    private final String name;
    private final List<Screen> screens;

    public Theatre(String id, String name, List<Screen> screens) {
        this.id = id;
        this.name = name;
        this.screens = screens;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

}
