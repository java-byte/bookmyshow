package service;

import models.Movie;
import models.Screen;
import models.Show;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShowService {

    private final Map<String, Show> showMap;
    private static ShowService showService;
    private ShowService(){
        showMap = new HashMap<>();
    }

    public static ShowService getInstance(){
        if(showService==null)
            showService = new ShowService();
        return showService;
    }

    public String createShow(Movie movie, Screen screen, Date startTime, int durationInSecond) {
        String showId = UUID.randomUUID().toString();
        Show show = new Show(showId,movie,screen,startTime,durationInSecond);
        showMap.put(showId, show);
        return showId;
    }
}
