package controller;

import models.Movie;
import models.Screen;
import service.ShowService;

import java.util.Date;

public class ShowController {
    private static ShowService showService = ShowService.getInstance();

    public String createShow(Movie movie, Screen screen, Date startTime, int durationInSecond){
        return showService.createShow(movie, screen, startTime, durationInSecond);
    }
}
