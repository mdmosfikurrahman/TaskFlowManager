package org.epde.tfm.projects.service.impl;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.projects.dto.request.ProjectRequest;
import org.epde.tfm.projects.dto.response.ProjectResponse;
import org.epde.tfm.common.exception.NotFoundException;
import org.epde.tfm.projects.mapper.ProjectMapper;
import org.epde.tfm.projects.model.Project;
import org.epde.tfm.users.model.User;
import org.epde.tfm.projects.repository.ProjectRepository;
import org.epde.tfm.users.repository.UserRepository;
import org.epde.tfm.projects.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repo;
    private final UserRepository userRepo;

    @Override
    public List<ProjectResponse> getAll() {
        List<ProjectResponse> projects = repo.findAll().stream().map(ProjectMapper::toResponse).toList();
        if (projects.isEmpty()) {
            throw new NotFoundException("No projects found");
        }
        return projects;
    }

    @Override
    public ProjectResponse getById(Long id) {
        return repo.findById(id)
                .map(ProjectMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + id));
    }

    @Override
    public ProjectResponse create(ProjectRequest dto) {
        User manager = userRepo.findById(dto.getManagerId())
                .orElseThrow(() -> new NotFoundException("Manager not found with id: " + dto.getManagerId()));
        return ProjectMapper.toResponse(repo.save(ProjectMapper.toEntity(dto, manager)));
    }

    @Override
    public ProjectResponse update(Long id, ProjectRequest dto) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Project not found with id: " + id);
        }
        User manager = userRepo.findById(dto.getManagerId())
                .orElseThrow(() -> new NotFoundException("Manager not found with id: " + dto.getManagerId()));

        Project updated = Project.builder()
                .id(id)
                .name(dto.getName())
                .description(dto.getDescription())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .manager(manager)
                .build();

        return ProjectMapper.toResponse(repo.save(updated));
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Project not found with id: " + id);
        }
        repo.deleteById(id);
    }
}