package dev.neeraj.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        /*
        * So first we will look for the movie with the imdbId, and then add
        * our reviewBody to its reviews list.
        * */
        // in our review repository we will insert a review - and will
        // since we need to save the data to the database!
        Review review = reviewRepository.insert(new Review(reviewBody));

        /**
        * So we are performing an update on the Movie class,
        * by searching for an entry with the same property that has been
        * passed as an argument to this method (imdbId) and applying the update
        * to the first match we find - using matching().is().apply().Update().push().value().first()
        * */
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
