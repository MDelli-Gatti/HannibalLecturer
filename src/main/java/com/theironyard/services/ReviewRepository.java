package com.theironyard.services;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaeldelli-gatti on 6/30/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    Iterable<Review> findByLecturer(Lecturer lecturer);
}
