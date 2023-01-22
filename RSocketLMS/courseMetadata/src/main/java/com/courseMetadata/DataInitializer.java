//package com.courseMetadata;
//
//import com.courseMetadata.dto.CourseMetaDataDto;
//import com.courseMetadata.model.CourseMetaData;
//import com.courseMetadata.repository.courseMedaDataRepository;
//import com.courseMetadata.util.ModelUtil;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.Arrays;
//@Configuration
//@RequiredArgsConstructor
//public class DataInitializer implements CommandLineRunner {
//
//    @Autowired
//    courseMedaDataRepository repository;
//    static CourseMetaData course1;
//    CourseMetaDataDto course2;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//         course1 = new CourseMetaData();
//        course1.setTitle("Java Programming Fundamentals");
//        course1.setDescription("Learn the basics of Java programming language");
//        course1.setRating(4.5);
//        course1.setLevel(1);
//        course1.setDuration(40);
//        course1.setStudentProgress(0.0);
//        course1.setPrerequisites("None");
//        course1.setLearningObjectives("Understand Java syntax and data types, create variables, and use control structures");
//        course1.setImageUrl("https://example.com/java_programming_fundamentals.jpg");
//        course1.setKeywords(new String[]{"Java", "Programming", "Fundamentals"});
//        course1.setLanguage("en-US");
//        course1.setYear(2022);
//        course1.setPrice("Free");
//        course1.setCategoryId("Programming");
//        course1.setAuthorIds(Arrays.asList("John Doe", "Jane Smith"));
//        course2 = new CourseMetaDataDto();
//        course2.setTitle("Data Science with Python");
//        course2.setDescription("Learn how to use Python for data analysis and visualization");
//        course2.setRating(4.8);
//        course2.setLevel(2);
//        course2.setDuration(50);
//        course2.setStudentProgress(0.0);
//        course2.setPrerequisites("Introduction to Python");
//        course2.setLearningObjectives("Understand the basics of data science, learn how to use Python libraries for data analysis and visualization");
//        course2.setImageUrl("https://example.com/data_science_python.jpg");
//        course2.setKeywords(new String[]{"Data Science", "Python"});
//        course2.setLanguage("en-US");
//        course2.setYear(2022);
//        course2.setPrice("Paid");
//        course2.setCategoryId("Data Science");
//        course2.setAuthorIds(Arrays.asList("John Doe", "Jane Smith"));
//
//        Flux.just(course1,course1)
//                .flatMap(this.repository::save)
//                .map(ModelUtil::toDto)
//                .doOnNext(System.out::println)
//                .subscribe();
//
//
//    }
//
//}
