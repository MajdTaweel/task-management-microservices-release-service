package com.asaltech.taskmanagement.releaseservice.repository;

import com.asaltech.taskmanagement.releaseservice.domain.Release;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Release entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReleaseRepository extends MongoRepository<Release, String> {
}
