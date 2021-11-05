package models;

import java.util.Date;

public class Show {
    private final String id;
    private final Movie movie;
    private final Screen screen;
    private final Date startTime;
    private final int durationInSecond;

    public Show(String id, Movie movie, Screen screen, Date startTime, int durationInSecond) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.durationInSecond = durationInSecond;
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getDurationInSecond() {
        return durationInSecond;
    }

}
