package service;

import models.Screen;
import models.Theatre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TheatreService {

    private Map<String, Theatre> theatreMap;
    private static TheatreService theatreService;

    private TheatreService(){
        theatreMap = new HashMap<>();
    }

    public static TheatreService getInstance(){
        if(theatreService==null)
            theatreService = new TheatreService();
        return theatreService;
    }

    public String createTheatre(String name, List<Screen> screenList) {
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, name, screenList);
        theatreMap.put(theatreId, theatre);
        return theatreId;
    }
}
