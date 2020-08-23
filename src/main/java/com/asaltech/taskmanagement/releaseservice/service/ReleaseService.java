package com.asaltech.taskmanagement.releaseservice.service;

import com.asaltech.taskmanagement.releaseservice.service.dto.ReleaseDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.asaltech.taskmanagement.releaseservice.domain.Release}.
 */
public interface ReleaseService {

    /**
     * Save a release.
     *
     * @param releaseDTO the entity to save.
     * @return the persisted entity.
     */
    ReleaseDTO save(ReleaseDTO releaseDTO);

    /**
     * Get all the releases.
     *
     * @return the list of entities.
     */
    List<ReleaseDTO> findAll();


    /**
     * Get the "id" release.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReleaseDTO> findOne(String id);

    /**
     * Delete the "id" release.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
