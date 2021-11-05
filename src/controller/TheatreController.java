package controller;

import models.Screen;
import service.TheatreService;

import java.util.List;

public class TheatreController {
    private static TheatreService theatreService = TheatreService.getInstance();

    public String createTheatre(String name, List<Screen> screenList){
        return theatreService.createTheatre(name, screenList);
    }
}
