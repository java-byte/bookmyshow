package models;

import java.time.Instant;
import java.util.Date;

public class SeatLock {
    private final Seat seat;
    private final Show show;
    private final int timeoutInSec;
    private final Date lockTime;
    private final User lockedBy;

    public boolean isLockedExpired(){
        final Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSec);
        final Instant currentInstant = new Date().toInstant();
        return lockInstant.isBefore(currentInstant);
    }

    public SeatLock(Seat seat, Show show, int timeoutInSec, Date lockTime, User lockedBy) {
        this.seat = seat;
        this.show = show;
        this.timeoutInSec = timeoutInSec;
        this.lockTime = lockTime;
        this.lockedBy = lockedBy;
    }

    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public int getTimeoutInSec() {
        return timeoutInSec;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public User getLockedBy() {
        return lockedBy;
    }
}
