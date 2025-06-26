package org.epde.tfm.service.impl;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.ProjectDTO;
import org.epde.tfm.infrastructure.exception.NotFoundException;
import org.epde.tfm.mapper.ProjectMapper;
import org.epde.tfm.model.User;
import org.epde.tfm.repository.ProjectRepository;
import org.epde.tfm.repository.UserRepository;
import org.epde.tfm.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repo;
    private final UserRepository userRepo;

    public List<ProjectDTO> getAll() {
        List<ProjectDTO> projects = repo.findAll().stream().map(ProjectMapper::toDto).toList();
        if (projects.isEmpty()) {
            throw new NotFoundException("No projects found");
        }
        return projects;
    }

    public ProjectDTO getById(Long id) {
        return repo.findById(id)
                .map(ProjectMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + id));
    }

    public ProjectDTO create(ProjectDTO dto) {
        User manager = userRepo.findById(dto.getManagerId())
                .orElseThrow(() -> new NotFoundException("Manager not found with id: " + dto.getManagerId()));
        return ProjectMapper.toDto(repo.save(ProjectMapper.toEntity(dto, manager)));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Project not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
