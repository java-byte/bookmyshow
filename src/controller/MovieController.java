package controller;

import service.MovieService;

public class MovieController {
    private MovieService movieService = MovieService.getInstance();
    public String createMovie(String name){
        return movieService.createMovie(name);
    }
}
