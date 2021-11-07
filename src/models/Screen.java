package models;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private final String id;
    private final String name;
    private final Theatre theatre;
    private final List<Seat> seatList;

    public Screen(String id, Theatre theatre, String name) {
        this.id = id;
        this.theatre = theatre;
        this.seatList = new ArrayList<>();
        this.name = name;
    }

    public void addSeat(Seat seat){
        this.seatList.add(seat);
    }
    public String getName() {
        return name;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public String getId() {
        return id;
    }

    public Theatre getTheatre() {
        return theatre;
    }

}
