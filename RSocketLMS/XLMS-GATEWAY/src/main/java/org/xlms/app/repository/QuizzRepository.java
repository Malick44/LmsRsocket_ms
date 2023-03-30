package org.xlms.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.xlms.app.model.Quizz;

/**
 * Spring Data MongoDB reactive repository for the Quizz entity.
 */
@SuppressWarnings("unused")
@Repository
public interface QuizzRepository extends ReactiveMongoRepository<Quizz, String> {}
