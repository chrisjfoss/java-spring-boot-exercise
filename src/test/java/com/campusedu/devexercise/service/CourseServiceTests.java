package com.campusedu.devexercise.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import com.campusedu.devexercise.repository.CourseRepository;

import com.campusedu.devexercise.config.Initialize;
import com.campusedu.devexercise.domain.Course;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseServiceTests {
    @Mock
    CourseRepository mockCourseRepository;

    @Test
    void findCourses_Should_ReturnCourses_Given_Code() {
        //Arrange
        try {
            Iterable<Course> courses = Initialize.loadData();    
            final String PREFIX = "";
            final Integer CODE = 400;
            List<Course> COURSES = new ArrayList<Course>();
            StreamSupport.stream(courses.spliterator(), false)
                                .filter(d -> d.getCodeNumber().equals(CODE))
                                .forEach(COURSES::add);

            when(mockCourseRepository.findByCodeNumber(CODE)).thenReturn(COURSES);
            CourseService courseService = new CourseService(mockCourseRepository);

            //Act
            List<Course> resultCourse = courseService.findCourses(PREFIX, CODE);

            //Assert
            assertEquals(COURSES.size(), resultCourse.size());
            for(Integer i = 0; i < COURSES.size(); ++i) {
                assertEquals(COURSES.get(i).getCodeSanitized(), resultCourse.get(i).getCodeSanitized());
            }
        }
        catch(IOException e) {
            fail("Unable to load test data.", e);
        }
    }

    @Test
    void findCourses_Should_ReturnCourses_Given_Prefix() {
        //Arrange
        try {
            Iterable<Course> courses = Initialize.loadData();    
            final String PREFIX = "MUS";
            final Integer CODE = -1;
            List<Course> COURSES = new ArrayList<Course>();
            StreamSupport.stream(courses.spliterator(), false)
                                .filter(d -> d.getPrefix().equals(PREFIX))
                                .forEach(COURSES::add);

            when(mockCourseRepository.findByPrefix(PREFIX)).thenReturn(COURSES);
            CourseService courseService = new CourseService(mockCourseRepository);

            //Act
            List<Course> resultCourse = courseService.findCourses(PREFIX, CODE);

            //Assert
            assertEquals(COURSES.size(), resultCourse.size());
            for(Integer i = 0; i < COURSES.size(); ++i) {
                assertEquals(COURSES.get(i).getCodeSanitized(), resultCourse.get(i).getCodeSanitized());
            }
        }
        catch(IOException e) {
            fail("Unable to load test data.", e);
        }
    }

    @Test
    void findCourses_Should_ReturnCourses_Given_CodeAndPrefix() {
        //Arrange
        try {
            Iterable<Course> courses = Initialize.loadData();    
            final String PREFIX = "ART";
            final Integer CODE = 152;
            List<Course> COURSES = new ArrayList<Course>();
            for(Course course : courses) {
                if(course.getPrefix().equals(PREFIX)) {
                    COURSES.add(course);
                }
            }

            when(mockCourseRepository.findByCodeNumberAndPrefix(CODE, PREFIX)).thenReturn(COURSES);
            CourseService courseService = new CourseService(mockCourseRepository);

            //Act
            List<Course> resultCourse = courseService.findCourses(PREFIX, CODE);

            //Assert
            assertEquals(COURSES.size(), resultCourse.size());
            for(Integer i = 0; i < COURSES.size(); ++i) {
                assertEquals(COURSES.get(i).getCodeSanitized(), resultCourse.get(i).getCodeSanitized());
            }
        }
        catch(IOException e) {
            fail("Unable to load test data.", e);
        }
    }
}