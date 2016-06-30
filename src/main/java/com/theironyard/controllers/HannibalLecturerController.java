package com.theironyard.controllers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michaeldelli-gatti on 6/30/16.
 */
@RestController
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
    public String postLecturer(String name, String topic, String image){
        Lecturer l = new Lecturer(name, topic, image);
        lecturers.save(l);
        return "redirect:/";
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> getReviews(int lecturerId){
        return reviews.findByLecturerId(lecturerId);
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public String postReviews(String author, String text, int lecturerId, boolean isGood){
        Lecturer l = lecturers.findOne(lecturerId);
        Review r = new Review(author, text, isGood, l);
        reviews.save(r);
        return "redirect:/";
    }
}
