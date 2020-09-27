package com.campusedu.devexercise.config;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.Iterator;

import com.campusedu.devexercise.domain.Course;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InitializeTests {
    @Test
    void loadData_Should_ReturnANonEmptyIterable() {
        try
        {
            //Arrange
            Integer numberOfCourses = 0;
            Iterator<Course> iterator;
            
            //Act
            Iterable<Course> courses = Initialize.loadData();
            iterator = courses.iterator();
            while(iterator.hasNext()) {
                iterator.next();
                numberOfCourses++;
            }
    
            //Assert
            assertTrue(numberOfCourses > 0);
        }
        catch(IOException e) {
            fail("loadData threw IOException", e);
        }
    }
}
