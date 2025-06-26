package org.epde.tfm.service.impl;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.TaskDTO;
import org.epde.tfm.infrastructure.exception.NotFoundException;
import org.epde.tfm.mapper.TaskMapper;
import org.epde.tfm.model.Project;
import org.epde.tfm.model.User;
import org.epde.tfm.repository.ProjectRepository;
import org.epde.tfm.repository.TaskRepository;
import org.epde.tfm.repository.UserRepository;
import org.epde.tfm.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repo;
    private final UserRepository userRepo;
    private final ProjectRepository projectRepo;

    public List<TaskDTO> getAll() {
        List<TaskDTO> tasks = repo.findAll().stream().map(TaskMapper::toDto).toList();
        if (tasks.isEmpty()) {
            throw new NotFoundException("No tasks found");
        }
        return tasks;
    }

    public TaskDTO getById(Long id) {
        return repo.findById(id)
                .map(TaskMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Task not found with id: " + id));
    }

    public TaskDTO create(TaskDTO dto) {
        User user = userRepo.findById(dto.getAssignedToId())
                .orElseThrow(() -> new NotFoundException("User not found with id: " + dto.getAssignedToId()));
        Project project = projectRepo.findById(dto.getProjectId())
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + dto.getProjectId()));
        return TaskMapper.toDto(repo.save(TaskMapper.toEntity(dto, user, project)));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Task not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
