package org.epde.tfm.features.tasks.mapper;

import org.epde.tfm.features.tasks.dto.request.TaskRequest;
import org.epde.tfm.features.tasks.dto.response.TaskResponse;
import org.epde.tfm.features.projects.model.Project;
import org.epde.tfm.features.tasks.model.Task;
import org.epde.tfm.features.users.model.User;

public class TaskMapper {

    public static TaskResponse toResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .dueDate(task.getDueDate())
                .assignedToName(task.getAssignedTo() != null ? task.getAssignedTo().getName() : null)
                .projectName(task.getProject() != null ? task.getProject().getName() : null)
                .build();
    }

    public static Task toEntity(TaskRequest dto, User user, Project project) {
        return Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .dueDate(dto.getDueDate())
                .assignedTo(user)
                .project(project)
                .build();
    }
}
