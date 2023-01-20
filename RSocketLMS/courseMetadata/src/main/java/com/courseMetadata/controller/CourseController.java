package com.courseMetadata.controller;

import com.courseMetadata.dto.CourseMetaDataDto;
import com.courseMetadata.service.CourseMetaDataService;
import com.courseMetadata.util.ModelUtil;
import jdk.jfr.MemoryAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@Controller("course")
public class CourseController {

    @Autowired
    public CourseMetaDataService service;

     @MessageMapping("get.all")
    public Flux<CourseMetaDataDto> getAllCourses(){

        return this.service.getAllCourses();
    }

    @MessageMapping("get.{id}")
    public Mono<CourseMetaDataDto> getCourseById(@DestinationVariable String id){
         return this.service.getCourseById(id);

    }
    @MessageMapping("update.{id}")
    public Mono<CourseMetaDataDto> updateCourse(@DestinationVariable String id,
                                                Mono<CourseMetaDataDto> dtoMono){

         return this.service.updateCourse(id,dtoMono);
    }
    @MessageMapping("delete.{id}")
    public Mono<Void> deleteCourse(@DestinationVariable String id){

         return this.service.deleteCourse(id);
    }

    @MessageMapping("get.{authorId}")
    public Flux<CourseMetaDataDto> getCourseByAuthorId(@DestinationVariable String authorId){
         return this.service.findByAuthorIdsContains(authorId);


    }

}
