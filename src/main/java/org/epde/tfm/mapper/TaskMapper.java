package org.epde.tfm.mapper;

import org.epde.tfm.dto.TaskDTO;
import org.epde.tfm.model.Project;
import org.epde.tfm.model.Task;
import org.epde.tfm.model.User;

public class TaskMapper {
    public static TaskDTO toDto(Task e) {
        TaskDTO d = new TaskDTO();
        d.setId(e.getId());
        d.setTitle(e.getTitle());
        d.setAssignedToId(e.getAssignedTo() != null ? e.getAssignedTo().getId() : null);
        d.setProjectId(e.getProject() != null ? e.getProject().getId() : null);
        return d;
    }

    public static Task toEntity(TaskDTO d, User user, Project project) {
        Task e = new Task();
        e.setId(d.getId());
        e.setTitle(d.getTitle());
        e.setAssignedTo(user);
        e.setProject(project);
        return e;
    }
}
