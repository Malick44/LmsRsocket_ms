package org.xlms.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.xlms.app.model.Author;

/**
 * Spring Data MongoDB reactive repository for the Author entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {}
