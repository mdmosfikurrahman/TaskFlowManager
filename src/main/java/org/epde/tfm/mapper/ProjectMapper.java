package org.epde.tfm.mapper;

import org.epde.tfm.dto.ProjectDTO;
import org.epde.tfm.model.Project;
import org.epde.tfm.model.User;

public class ProjectMapper {
    public static ProjectDTO toDto(Project e) {
        ProjectDTO d = new ProjectDTO();
        d.setId(e.getId());
        d.setName(e.getName());
        d.setManagerId(e.getManager() != null ? e.getManager().getId() : null);
        return d;
    }

    public static Project toEntity(ProjectDTO d, User manager) {
        Project e = new Project();
        e.setId(d.getId());
        e.setName(d.getName());
        e.setManager(manager);
        return e;
    }
}
