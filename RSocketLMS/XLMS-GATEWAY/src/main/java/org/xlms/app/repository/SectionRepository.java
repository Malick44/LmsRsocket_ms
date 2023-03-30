package org.xlms.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.xlms.app.model.Section;

/**
 * Spring Data MongoDB reactive repository for the Section entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SectionRepository extends ReactiveMongoRepository<Section, String> {}
