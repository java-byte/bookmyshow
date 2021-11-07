package service;

import models.Seat;
import models.SeatLock;
import models.Show;
import models.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatLockService {

    public static SeatLockService seatLockService;

    private final int lockTimeOut;
    private final Map<Show, Map<Seat, SeatLock>> seatLockMap;

    private SeatLockService(int lockTimeOut) {
        this.lockTimeOut = lockTimeOut;
        this.seatLockMap = new HashMap<>();
    }

    public static  SeatLockService getInstance(int lockTimeOut){
        if(seatLockService==null)
            seatLockService = new SeatLockService(lockTimeOut);
        return seatLockService;
    }

    synchronized public void lockSeats(Show show, List<Seat> seats, User user){
        if(isLocked(show, seats)){
            System.out.println("Seat is already locked.");
            return;
        }
        for(Seat seat: seats){
            if(!seatLockMap.containsKey(show)){
                seatLockMap.put(show, new HashMap<>());
            }
            SeatLock seatLock = new SeatLock(seat, show, lockTimeOut, new Date(), user);
            seatLockMap.get(show).put(seat, seatLock);
        }

    }

    public void unlockSeat(Show show, List<Seat> seats, User user){
        for(Seat seat: seats){
            if(isValidLock(show, seat, user)){
                seatLockMap.get(show).remove(seat);
            }
        }

    }

    private boolean isValidLock(Show show, Seat seat, User user) {
        return seatLockMap.containsKey(show)
                && seatLockMap.get(show).containsKey(seat)
                && seatLockMap.get(show).get(seat).getLockedBy().equals(user);
    }

    private boolean isLocked(Show show, List<Seat> seats) {
        if(!seatLockMap.containsKey(show)) return false;
        Map<Seat, SeatLock> values = seatLockMap.get(show);
        for(Seat seat : seats){
            if(values.containsKey(seat) && !values.get(seat).isLockedExpired()) return true;
        }
        return false;
    }

    public Map<Show, Map<Seat, SeatLock>> getSeatLockMap() {
        return seatLockMap;
    }
}
