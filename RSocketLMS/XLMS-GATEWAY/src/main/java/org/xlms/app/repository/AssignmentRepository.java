package org.xlms.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.xlms.app.model.Assignment;

/**
 * Spring Data MongoDB reactive repository for the Assignment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AssignmentRepository extends ReactiveMongoRepository<Assignment, String> {}
