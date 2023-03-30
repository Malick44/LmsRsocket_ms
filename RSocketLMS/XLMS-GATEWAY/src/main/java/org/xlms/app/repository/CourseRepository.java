package org.xlms.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.xlms.app.model.Course;

/**
 * Spring Data MongoDB reactive repository for the Course entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String> {}
