package com.theironyard.controllers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by michaeldelli-gatti on 6/30/16.
 */
@Controller
public class HannibalLecturerController {
    @Autowired
    ReviewRepository reviews;

    @Autowired
    LecturerRepository lecturers;

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public Iterable<Lecturer> getLecturer(){
        return lecturers.findAll();
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public void postLecturer(String name, String topic, String image){
        Lecturer l = new Lecturer(name, topic, image);
        lecturers.save(l);
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> getReviews(){
        return reviews.findAll();
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void postReviews(String author, String text, boolean isGood, Lecturer lecturer){
        Review r = new Review(author, text, isGood, lecturer);
        reviews.save(r);
    }
}
