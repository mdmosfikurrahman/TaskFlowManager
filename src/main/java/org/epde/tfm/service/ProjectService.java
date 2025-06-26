package org.epde.tfm.service;

import org.epde.tfm.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> getAll();

    ProjectDTO getById(Long id);

    ProjectDTO create(ProjectDTO dto);

    void delete(Long id);
}
