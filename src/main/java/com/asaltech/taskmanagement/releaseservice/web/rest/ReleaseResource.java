package com.asaltech.taskmanagement.releaseservice.web.rest;

import com.asaltech.taskmanagement.releaseservice.service.ReleaseService;
import com.asaltech.taskmanagement.releaseservice.service.dto.ReleaseDTO;
import com.asaltech.taskmanagement.releaseservice.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.asaltech.taskmanagement.releaseservice.domain.Release}.
 */
@RestController
@RequestMapping("/api")
public class ReleaseResource {

    private static final String ENTITY_NAME = "releaseServiceRelease";
    private final Logger log = LoggerFactory.getLogger(ReleaseResource.class);
    private final ReleaseService releaseService;
    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    public ReleaseResource(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    /**
     * {@code POST  /releases} : Create a new release.
     *
     * @param releaseDTO the releaseDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new releaseDTO, or with status {@code 400 (Bad Request)} if the release has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/releases")
    public ResponseEntity<ReleaseDTO> createRelease(@Valid @RequestBody ReleaseDTO releaseDTO) throws URISyntaxException {
        log.debug("REST request to save Release : {}", releaseDTO);
        if (releaseDTO.getId() != null) {
            throw new BadRequestAlertException("A new release cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReleaseDTO result = releaseService.save(releaseDTO);
        return ResponseEntity.created(new URI("/api/releases/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /releases} : Updates an existing release.
     *
     * @param releaseDTO the releaseDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated releaseDTO,
     * or with status {@code 400 (Bad Request)} if the releaseDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the releaseDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/releases")
    public ResponseEntity<ReleaseDTO> updateRelease(@Valid @RequestBody ReleaseDTO releaseDTO) throws URISyntaxException {
        log.debug("REST request to update Release : {}", releaseDTO);
        if (releaseDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReleaseDTO result = releaseService.save(releaseDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, releaseDTO.getId()))
            .body(result);
    }

    /**
     * {@code GET  /releases} : get all the releases.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of releases in body.
     */
    @GetMapping("/releases")
    public List<ReleaseDTO> getAllReleases() {
        log.debug("REST request to get all Releases");
        return releaseService.findAll();
    }

    /**
     * {@code GET  /releases/:id} : get the "id" release.
     *
     * @param id the id of the releaseDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the releaseDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/releases/{id}")
    public ResponseEntity<ReleaseDTO> getRelease(@PathVariable String id) {
        log.debug("REST request to get Release : {}", id);
        Optional<ReleaseDTO> releaseDTO = releaseService.findOne(id);
        return ResponseUtil.wrapOrNotFound(releaseDTO);
    }

    /**
     * {@code DELETE  /releases/:id} : delete the "id" release.
     *
     * @param id the id of the releaseDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/releases/{id}")
    public ResponseEntity<Void> deleteRelease(@PathVariable String id) {
        log.debug("REST request to delete Release : {}", id);
        releaseService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id)).build();
    }
}
