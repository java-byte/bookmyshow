package models;

import java.util.List;

public class Booking {
    private final String id;
    private final Show show;
    private final User user;
    private final List<Seat> seatsBooked;
    private final BookingStatus bookingStatus;

    public Booking(String id, Show show, User user, List<Seat> seats) {
        this.id = id;
        this.show = show;
        this.user = user;
        this.seatsBooked = seats;
        this.bookingStatus = BookingStatus.IN_PROGRESS;
    }

    public Show getShow() {
        return show;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

}
