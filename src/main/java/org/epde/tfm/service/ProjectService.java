package org.epde.tfm.service;

import org.epde.tfm.dto.request.ProjectRequest;
import org.epde.tfm.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectResponse> getAll();
    ProjectResponse getById(Long id);
    ProjectResponse create(ProjectRequest dto);
    ProjectResponse update(Long id, ProjectRequest dto);
    void delete(Long id);
}
