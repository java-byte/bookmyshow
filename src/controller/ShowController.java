package controller;

import models.Movie;
import models.Screen;
import models.Seat;
import service.ShowService;

import java.util.Date;
import java.util.List;

public class ShowController {
    private static ShowService showService = ShowService.getInstance();

    public String createShow(Movie movie, Screen screen, Date startTime, int durationInSecond){
        return showService.createShow(movie, screen, startTime, durationInSecond);
    }

    public List<Seat> findAvailableSeats(String show) {
        return showService.findAvailableSeats(show);
    }
}
