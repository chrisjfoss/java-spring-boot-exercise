package com.campusedu.devexercise.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.campusedu.devexercise.domain.Course;
import com.campusedu.devexercise.repository.CourseRepository;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Initialize {
    public static Iterable<Course> loadData() throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get(".", Constants.INITIAL_DATA_PATH));
		return new CsvToBeanBuilder<Course>(reader)
						.withType(Course.class)
						.withSeparator('\t')
						.build();
	}

    @Bean CommandLineRunner initializeDatabase(CourseRepository courseRepository) {
		return args -> {
			if(courseRepository.count() != 0) { return; }
            Iterable<Course> courses = loadData();
			courseRepository.saveAll(courses);
		};
	}
}
