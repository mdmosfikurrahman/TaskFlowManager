package org.epde.tfm.projects.mapper;

import org.epde.tfm.projects.dto.request.ProjectRequest;
import org.epde.tfm.projects.dto.response.ProjectResponse;
import org.epde.tfm.projects.model.Project;
import org.epde.tfm.users.model.User;

public class ProjectMapper {

    public static ProjectResponse toResponse(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .managerName(project.getManager() != null ? project.getManager().getName() : null)
                .build();
    }

    public static Project toEntity(ProjectRequest request, User manager) {
        return Project.builder()
                .name(request.getName())
                .description(request.getDescription())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .manager(manager)
                .build();
    }
}
