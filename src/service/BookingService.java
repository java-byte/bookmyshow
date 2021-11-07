package service;

import models.*;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {

    private Map<String, Booking> bookingMap;
    private static BookingService bookingService;
    private static SeatLockService seatLockService = SeatLockService.getInstance(1000);
    private BookingService(){
        bookingMap = new HashMap<>();
    }

    public Map<String, Booking> getBookingMap() {
        return bookingMap;
    }

    public static BookingService getInstance(){
        if(bookingService==null)
            bookingService = new BookingService();
        return bookingService;
    }

    public String createBooking(Show show, User user, List<Seat> seats){
        if(checkIfAnySeatBooked(show, seats)){
            System.out.println("Seat already booked. Select any other seat to book");
            return null;
        }
        seatLockService.lockSeats(show, seats, user);
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, show, user, seats);
        bookingMap.put(bookingId, booking);
        return bookingId;
    }

    private boolean checkIfAnySeatBooked(Show show, List<Seat> seats) {
        List<Seat> bookedSeat = getAllBookedSeat(show);
        for(Seat seat: seats){
            if(bookedSeat.contains(seat))
                return true;
        }
        return false;
    }

    private List<Seat> getAllBookedSeat(Show show) {
        List<Booking> getAllBookings = getAllBookings(show);
        List<Seat> bookedSeat = new ArrayList<>();
        for(Booking booking:getAllBookings){
            booking.getSeatsBooked().addAll(bookedSeat);
        }
        return bookedSeat;
    }

    private List<Booking> getAllBookings(Show show) {
        return bookingMap.values().stream().filter(item -> item.getShow().equals(show) && item.getBookingStatus().equals(BookingStatus.BOOKED)).collect(Collectors.toList());
    }
}
