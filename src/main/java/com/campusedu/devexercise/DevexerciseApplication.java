package com.campusedu.devexercise;

import com.campusedu.devexercise.config.Initialize;
import com.campusedu.devexercise.domain.Course;
import com.campusedu.devexercise.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DevexerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevexerciseApplication.class, args);
	}

	@Bean CommandLineRunner initializeDatabase(CourseRepository courseRepository) {
		return args -> {
			if(courseRepository.count() != 0) { return; }
            Iterable<Course> courses = Initialize.loadData();
			courseRepository.saveAll(courses);
		};
	}
}
