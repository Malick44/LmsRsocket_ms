package org.xlms.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.xlms.app.model.Instructor;

/**
 * Spring Data MongoDB reactive repository for the Instructor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InstructorRepository extends ReactiveMongoRepository<Instructor, String> {}
