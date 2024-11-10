/*
* A Service class is a class where you write all your business logic!
* It is where most of your processing happens!
* */
package dev.neeraj.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    // using Autowired, we can just let Spring handle all the dependency injections
    // whenever required!
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        /*
         *  the findAll() method is in the MongoRepository class, that has been
         *  extended by the MovieRepository interface that we defined.
         *  the allMovies() function should just return a list of all the movies
         *  in our database!
         */
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId) {
        /*
        * singleMovie() finds a movie by the id specified by the function parameter
        * and returns it, that's all. It searches the database.
        * So the thing is, the id may or may not be present - for that we utilize
        * Java's Optional utility - so that it returns nothing if there's nothing,
        * and returns the movie details if it finds something!
        * */
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
