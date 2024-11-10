/**
 * This ReviewController class will have just one POST method, tbh.
 * That we use for updating the reviewIds list in our database.
 * */
package dev.neeraj.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
// the CrossOrigin annotation is very important - so that we can access the
// endpoints from another port or address! That is required if we wanna build a
// frontend to our backend!
// since our frontend will be tested on port 3000, we're giving that address!
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
