package com.campusedu.devexercise.service;

import java.util.List;

import com.campusedu.devexercise.domain.Course;
import com.campusedu.devexercise.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private final CourseRepository courseRepository;

    public CourseService(
        CourseRepository courseRepository
    ) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findCourses(String prefix, 
                                    Integer code) {
        if(!prefix.isEmpty() && code >= 0) {
            return courseRepository.findByCodeNumberAndPrefix(code, prefix);
        }
        else if(!prefix.isEmpty()) {
            return courseRepository.findByPrefix(prefix);
        }
        else if(code >= 0) {
            return courseRepository.findByCodeNumber(code);
        }
        return courseRepository.findAll();
    }

}
