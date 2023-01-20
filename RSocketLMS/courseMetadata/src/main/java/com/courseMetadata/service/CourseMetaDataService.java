package com.courseMetadata.service;

import com.courseMetadata.dto.CourseMetaDataDto;
import com.courseMetadata.model.CourseMetaData;
import com.courseMetadata.repository.courseMedaDataRepository;
import com.courseMetadata.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.UnaryOperator;

@Service
public class CourseMetaDataService {
    @Autowired
    courseMedaDataRepository repository;

    public Flux<CourseMetaDataDto> getAllCourses(){

        return this.repository.findAll()
                .map(ModelUtil::toDto);
    }

    public Mono<CourseMetaDataDto> getCourseById(final String id){

        return this.repository.findById(id)
                .map(ModelUtil::toDto);
    }

    public Mono<CourseMetaDataDto> createCourse(Mono<CourseMetaDataDto> monoDto){

        return monoDto.map(ModelUtil::toEntity)
                .flatMap( this.repository::save)
                .map(ModelUtil::toDto);


    }

    public Mono<CourseMetaDataDto> updateCourse(final String id,Mono <CourseMetaDataDto> monoDto){

       return this.repository.findById(id)
               .flatMap(course -> monoDto.map(ModelUtil::toEntity)
                       .doOnNext(e ->e.setId(id)))
               .flatMap(this.repository::save)
               .map(ModelUtil::toDto);



    }

    public Mono<Void> deleteCourse(final String id) {
        return this.repository.deleteById(id);
    }

    public Flux<CourseMetaDataDto> findByAuthorId( String id){

        return this.repository.findByAuthorIdsContains(id)
                .map(ModelUtil::toDto);
}
 public  Flux<CourseMetaDataDto> findByAuthorIdsContains(String authorId){
        return this.repository.findByAuthorIdsContains(authorId)
                .map(ModelUtil::toDto);
 }

}
