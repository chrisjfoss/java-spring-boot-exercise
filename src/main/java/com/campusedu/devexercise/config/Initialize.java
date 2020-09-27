package com.campusedu.devexercise.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.campusedu.devexercise.domain.Course;
import com.opencsv.bean.CsvToBeanBuilder;

public class Initialize {
    public static Iterable<Course> loadData() throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get(".", Constants.INITIAL_DATA_PATH));
		return new CsvToBeanBuilder<Course>(reader)
						.withType(Course.class)
						.withSeparator('\t')
						.build();
	}

    private Initialize() { throw new IllegalStateException("Utility class"); }
}
