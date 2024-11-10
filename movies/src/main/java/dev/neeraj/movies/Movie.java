/*
*   This is our Movie Model Class.
* */
package dev.neeraj.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// this annotation specifies that this class represents
// each document in our collection
@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    /*
    * The following attributes are going to
    * be details of each movie
    * we have in our collection:
    * */
    // this is the Mongo ObjectId
    @Id
    private ObjectId id;
    // a string that represents the imdb ID of the movie
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    // genres, backdrops are going to be a list of strings (array of strings)
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;

}
