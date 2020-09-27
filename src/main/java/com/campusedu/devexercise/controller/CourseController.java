package com.campusedu.devexercise.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.campusedu.devexercise.domain.Course;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @GetMapping(value = "/getCourses{prefix}{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getCourses(@RequestParam("prefix") Optional<String> prefix,
                                   @RequestParam("code") Optional<String> code) {
        return new ArrayList<>();
    }
}