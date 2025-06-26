package org.epde.tfm.projects.resolver;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.projects.dto.request.ProjectRequest;
import org.epde.tfm.projects.dto.response.ProjectResponse;
import org.epde.tfm.projects.service.ProjectService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectGraphQLController {
    private final ProjectService service;

    @QueryMapping
    public List<ProjectResponse> getProjects() {
        return service.getAll();
    }

    @QueryMapping
    public ProjectResponse getProjectById(@Argument Long id) {
        return service.getById(id);
    }

    @MutationMapping
    public ProjectResponse createProject(@Argument ProjectRequest input) {
        return service.create(input);
    }

    @MutationMapping
    public ProjectResponse updateProject(@Argument Long id, @Argument ProjectRequest input) {
        return service.update(id, input);
    }

    @MutationMapping
    public Boolean deleteProject(@Argument Long id) {
        service.delete(id);
        return true;
    }
}
