package org.xlms.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.xlms.app.model.Rating;

/**
 * Spring Data MongoDB reactive repository for the Rating entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RatingRepository extends ReactiveMongoRepository<Rating, String> {}
