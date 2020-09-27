package com.campusedu.devexercise.repository;

import java.util.List;

import com.campusedu.devexercise.domain.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link Course} entity
 * https://stackoverflow.com/questions/40330369/spring-data-jpa-underlying-mechanism-without-implementation
 * 
 * There is no implementation for this repository in the code. The Spring Container automatically creates an implementation at runtime.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
      List<Course> findByCodeNumber(Integer code);
      List<Course> findByPrefix(String prefix);
      List<Course> findByCodeNumberAndPrefix(Integer code, String prefix);
}
