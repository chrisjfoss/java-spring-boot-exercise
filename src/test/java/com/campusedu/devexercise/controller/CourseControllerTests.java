package com.campusedu.devexercise.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import com.campusedu.devexercise.service.CourseService;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseControllerTests {
    @Mock
    CourseService mockCourseService;

	@Test
	void getCourses_Should_Call_CourseService_findCourses() {
        //Arrange
        CourseController courseController = new CourseController(mockCourseService);
        final Optional<String> PREFIX = Optional.empty();
        final Optional<Integer> CODE = Optional.empty();

        //Act
        courseController.getCourses(PREFIX, CODE);
        
        //Assert
        verify(mockCourseService, times(1)).findCourses(anyString(), anyInt());
	}

    @Test
    void getCourses_Should_PassEmptyStringsTo_CourseService_Given_NoParameters() {
        //Arrange
        CourseController courseController = new CourseController(mockCourseService);
        final Optional<String> PREFIX = Optional.empty();
        final Optional<Integer> CODE = Optional.empty();

        //Act
        courseController.getCourses(PREFIX, CODE);

        //Assert
        verify(mockCourseService, times(1)).findCourses("", -1);
    }

    @Test
    void getCourses_Should_PassParametersTo_CourseService() {
        //Arrange
        CourseController courseController = new CourseController(mockCourseService);
        final String PREFIX = "EDU";
        final Integer CODE = 400;

        //Act
        courseController.getCourses(Optional.of(PREFIX), Optional.of(CODE));

        //Assert
        verify(mockCourseService, times(1)).findCourses(PREFIX, CODE);
    }
}

