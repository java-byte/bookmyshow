package service;

import models.Movie;
import models.Screen;
import models.Seat;
import models.Show;

import java.util.*;

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

    public Map<String, Show> getShowMap() {
        return showMap;
    }

    public List<Seat> findAvailableSeats(String showId) {
        if(!showMap.containsKey(showId)){
            System.out.println("This show with showId: "+showId+" doesn't exists!!");
            return null;
        }
        Show show = showMap.get(showId);
        List<Seat> seatList = show.getScreen().getSeatList();
        return seatList;
    }
}
