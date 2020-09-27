package com.campusedu.devexercise.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campusedu.devexercise.domain.Course;
import com.campusedu.devexercise.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    
    @GetMapping(value = "/getCourses{prefix}{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getCourses(@RequestParam("prefix") Optional<String> prefix,
                                   @RequestParam("code") Optional<Integer> code) {
        return courseService.findCourses(prefix.orElse(""), code.orElse(-1));
    }
}