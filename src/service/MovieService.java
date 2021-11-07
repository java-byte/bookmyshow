package service;

import models.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {
    private Map<String, Movie> movieMap;
    private static MovieService movieService;

    private MovieService(){
        movieMap = new HashMap<>();
    }

    public static MovieService getInstance(){
        if(movieService==null)
            movieService = new MovieService();
        return movieService;
    }

    public Map<String, Movie> getMovieMap() {
        return movieMap;
    }

    public String createMovie(String name){
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId,name);
        movieMap.put(movieId, movie);
        return movieId;
    }

}
