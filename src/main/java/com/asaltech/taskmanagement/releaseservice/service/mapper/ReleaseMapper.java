package com.asaltech.taskmanagement.releaseservice.service.mapper;


import com.asaltech.taskmanagement.releaseservice.domain.Release;
import com.asaltech.taskmanagement.releaseservice.service.dto.ReleaseDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Release} and its DTO {@link ReleaseDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReleaseMapper extends EntityMapper<ReleaseDTO, Release> {


    default Release fromId(String id) {
        if (id == null) {
            return null;
        }
        Release release = new Release();
        release.setId(id);
        return release;
    }
}
