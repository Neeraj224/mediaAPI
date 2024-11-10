/*
* The Repository layer is the Data Access Layer for our application!
* This is where we
* */
package dev.neeraj.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    // we'll use methods provided by the MongoRepository class like findAll(), findOne() etc.

    /**
     * We can actually form dynamic queries like the one below using any property name
     * in our model class, as long as they are unique (the property names!)
     * */
    // this method will find a movie by its IMDb id - all you have to do is just name the property
    // correctly w.r.t. the property in the db collection - should have the same name - here, it's 'imdbId':
    Optional<Movie> findMovieByImdbId(String imdbId);
}
