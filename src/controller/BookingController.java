package controller;

import models.Seat;
import models.Show;
import models.User;
import service.BookingService;

import java.util.List;

public class BookingController {

    private static BookingService bookingService = BookingService.getInstance();

    public String createBooking(Show show, User user, List<Seat> seats){
        return bookingService.createBooking(show, user, seats);
    }
}
