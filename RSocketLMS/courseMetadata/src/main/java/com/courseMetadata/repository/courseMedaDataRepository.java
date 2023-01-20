package com.courseMetadata.repository;

import com.courseMetadata.dto.CourseMetaDataDto;
import com.courseMetadata.model.CourseMetaData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface courseMedaDataRepository extends ReactiveMongoRepository<CourseMetaData, String> {
    Flux<CourseMetaData> findByAuthorIdsContains(@NonNull String authorId);



}
