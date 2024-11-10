/*
* As the name says, this is our Controller class!
* */
package dev.neeraj.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// this is our controller class for movies.
// it will deal with APIs relating mainly to fetching and sending the movie data.
@RestController
@RequestMapping("/api/v1/movies")
// the CrossOrigin annotation is very important - so that we can access the
// endpoints from another port or address! That is required if we wanna build a
// frontend to our backend!
// since our frontend will be tested on port 3000, we're giving that address!
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    /**
     * so we need the MovieService class object that has the allMovies()
     * function [that we get from MovieRepository class] -> so allMovies()
     * returns a list of Movie class objects that has getters for all the
     * movie details!
     */
    @Autowired
    private MovieService movieService;

    /**
     * This is going to be a GET request for the '.api/v1/movies' endpoint
     * that fetches all the movies and their details from the database and
     * returns it.
     */
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
//        return new ResponseEntity<String>("All Movies", HttpStatus.OK);
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        /*
        * @PathVariable takes the variable from the api-path and uses it for processing.
        * It's gonna be an ObjectId that we are gonna use to search our database using the
        * Service's Repository's findById()!
        * */
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
