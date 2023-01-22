package com.courseMetadata.controller;

import com.courseMetadata.dto.CourseMetaDataDto;
import com.courseMetadata.service.CourseMetaDataService;
import com.courseMetadata.util.ModelUtil;
import jdk.jfr.MemoryAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@Controller()
@MessageMapping("course")
public class CourseController {

    @Autowired
    public CourseMetaDataService service;

     @MessageMapping("get.all")
    public Flux<CourseMetaDataDto> getAllCourses(){

        return this.service.getAllCourses();
    }

//get a course by id
    @MessageMapping("get.{id}")
    public Mono<CourseMetaDataDto> getCourseById(@DestinationVariable String id){
         return this.service.getCourseById(id);

    }
    //create a course
   @MessageMapping("create")
    public Mono<CourseMetaDataDto> createCourse( Mono<CourseMetaDataDto> dtoMono){

         return this.service.createCourse(dtoMono);
    }

    @MessageMapping("update.{id}")
    public Mono<CourseMetaDataDto> updateCourse(@DestinationVariable String id,
                                                Mono<CourseMetaDataDto> dtoMono){

         return this.service.updateCourse(id,dtoMono);
    }
    //delete a course by id
    @MessageMapping("delete.{id}")
    public Mono<Void> deleteCourse(@DestinationVariable String id){

         return this.service.deleteCourse(id);
    }

    @MessageMapping("get.{authorId}")
    public Flux<CourseMetaDataDto> getCourseByAuthorId(@DestinationVariable String authorId){
         return this.service.findByAuthorIdsContains(authorId);


    }
    // exception handler should be in the same class as the controller
    @MessageExceptionHandler
    public Mono<String> handleException(Exception e){
        return Mono.just(e.getMessage());
    }

}
