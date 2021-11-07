package controller;

import models.Screen;
import models.Seat;
import models.Theatre;
import service.TheatreService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TheatreController {
    private static TheatreService theatreService = TheatreService.getInstance();

    public String createTheatre(String name){
        return theatreService.createTheatre(name);
    }

    public String createScreen(Theatre theatre, String name){
        return theatreService.createScreen(theatre,name);
    }
    
    public List<String> addSeat(int row, int col, String screenId){
        List<Seat> seats = new ArrayList<>();
        List<String> seatIds = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                String seatId = UUID.randomUUID().toString();
                seatIds.add(seatId);
                Seat seat = new Seat(seatId, i, j);
                seats.add(seat);
            }
        }
        theatreService.addSeats(screenId, seats);
        return seatIds;
    }
}
