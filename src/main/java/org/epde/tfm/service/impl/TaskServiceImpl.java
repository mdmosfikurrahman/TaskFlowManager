package org.epde.tfm.service.impl;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.request.TaskRequest;
import org.epde.tfm.dto.response.TaskResponse;
import org.epde.tfm.infrastructure.exception.NotFoundException;
import org.epde.tfm.mapper.TaskMapper;
import org.epde.tfm.model.Project;
import org.epde.tfm.model.Task;
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

    @Override
    public List<TaskResponse> getAll() {
        List<TaskResponse> tasks = repo.findAll().stream().map(TaskMapper::toResponse).toList();
        if (tasks.isEmpty()) {
            throw new NotFoundException("No tasks found");
        }
        return tasks;
    }

    @Override
    public TaskResponse getById(Long id) {
        return repo.findById(id)
                .map(TaskMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Task not found with id: " + id));
    }

    @Override
    public TaskResponse create(TaskRequest dto) {
        User user = userRepo.findById(dto.getAssignedToId())
                .orElseThrow(() -> new NotFoundException("User not found with id: " + dto.getAssignedToId()));
        Project project = projectRepo.findById(dto.getProjectId())
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + dto.getProjectId()));
        return TaskMapper.toResponse(repo.save(TaskMapper.toEntity(dto, user, project)));
    }

    @Override
    public TaskResponse update(Long id, TaskRequest dto) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Task not found with id: " + id);
        }
        User user = userRepo.findById(dto.getAssignedToId())
                .orElseThrow(() -> new NotFoundException("User not found with id: " + dto.getAssignedToId()));
        Project project = projectRepo.findById(dto.getProjectId())
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + dto.getProjectId()));

        Task updated = Task.builder()
                .id(id)
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .dueDate(dto.getDueDate())
                .assignedTo(user)
                .project(project)
                .build();

        return TaskMapper.toResponse(repo.save(updated));
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Task not found with id: " + id);
        }
        repo.deleteById(id);
    }
}