package driver;

import controller.MovieController;
import controller.ShowController;
import controller.TheatreController;
import models.*;
import service.BookingService;
import service.MovieService;
import service.ShowService;
import service.TheatreService;

import java.util.*;
import java.util.stream.Collectors;

public class Driver {

    private static TheatreService theatreService = TheatreService.getInstance();
    private static MovieService movieService = MovieService.getInstance();
    private static ShowService showService = ShowService.getInstance();
    private static BookingService bookingService = BookingService.getInstance();

    public static void main(String[] args) {
        String userId1 = UUID.randomUUID().toString();
        User user1 = new User(userId1, "User-1");

        String userId2 = UUID.randomUUID().toString();
        User user2 = new User(userId2, "User-2");

        MovieController movieController = new MovieController();
        final String movieId = movieController.createMovie("Movie-1");

        TheatreController theatreController = new TheatreController();
        String theatreId = theatreController.createTheatre("Theatre-1");
        Theatre theatre = theatreService.getTheatreMap().get(theatreId);
        final String screenId = theatreController.createScreen(theatre, "screen-1");
        Screen screen = theatreService.getScreenMap().get(screenId);

        final List<String> seatsId = theatreController.addSeat(2,10,screenId);

        ShowController showController = new ShowController();
        Movie movie = movieService.getMovieMap().get(movieId);
        final String show = showController.createShow(movie, screen, new Date(), 2*60*60);

        List<Seat> availableShowSeat = showController.findAvailableSeats(show);
        List<Seat> exceptList = Collections.unmodifiableList(new ArrayList<>());
        validateSeatAvailable(seatsId, availableShowSeat, exceptList);


        // Test Case - 2



    }

    private static void validateSeatAvailable(List<String> seatsId, List<Seat> availableShowSeat, List<Seat> exceptList) {
        for(Seat seat:availableShowSeat){
            if(!seatsId.contains(seat.getId()) && !exceptList.contains(seat)){
                System.out.println("Test failed: available seat is not present in seats");
                return;
            }
        }
        System.out.println("Test case passed!!");
    }
}
