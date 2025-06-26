package org.epde.tfm.controller.graphql;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.request.TaskRequest;
import org.epde.tfm.dto.response.TaskResponse;
import org.epde.tfm.service.TaskService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskGraphQLController {
    private final TaskService service;

    @QueryMapping
    public List<TaskResponse> getTasks() {
        return service.getAll();
    }

    @QueryMapping
    public TaskResponse getTaskById(@Argument Long id) {
        return service.getById(id);
    }

    @MutationMapping
    public TaskResponse createTask(@Argument TaskRequest input) {
        return service.create(input);
    }

    @MutationMapping
    public TaskResponse updateTask(@Argument Long id, @Argument TaskRequest input) {
        return service.update(id, input);
    }

    @MutationMapping
    public Boolean deleteTask(@Argument Long id) {
        service.delete(id);
        return true;
    }
}
