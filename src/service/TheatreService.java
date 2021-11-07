package service;

import models.Screen;
import models.Seat;
import models.Theatre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TheatreService {

    private Map<String, Theatre> theatreMap;
    private Map<String, Screen> screenMap;
    private static TheatreService theatreService;

    private TheatreService(){
        theatreMap = new HashMap<>();
        screenMap = new HashMap<>();
    }

    public static TheatreService getInstance(){
        if(theatreService==null)
            theatreService = new TheatreService();
        return theatreService;
    }

    public String createTheatre(String name) {
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, name);
        theatreMap.put(theatreId, theatre);
        return theatreId;
    }

    public String createScreen(Theatre theatre, String name) {
        String screeId = UUID.randomUUID().toString();
        Screen screen = new Screen(screeId, theatre, name);
        screenMap.put(screeId, screen);
        return screeId;
    }

    public void addSeats(String screenId, List<Seat> seats) {
        if(!screenMap.containsKey(screenId)){
            System.out.println("No such screen exists!!");
            return;
        }
        screenMap.get(screenId).getSeatList().addAll(seats);
    }

    public Map<String, Theatre> getTheatreMap() {
        return theatreMap;
    }

    public Map<String, Screen> getScreenMap() {
        return screenMap;
    }
}
