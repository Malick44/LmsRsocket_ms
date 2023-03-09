package org.xlms.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.xlms.app.model.Authority;

/**
 * Spring Data MongoDB repository for the {@link Authority} entity.
 */

public interface AuthorityRepository extends ReactiveMongoRepository<Authority, String> {}
