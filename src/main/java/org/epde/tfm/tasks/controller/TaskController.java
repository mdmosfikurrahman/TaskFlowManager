package org.epde.tfm.tasks.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.epde.tfm.tasks.dto.request.TaskRequest;
import org.epde.tfm.tasks.dto.response.TaskResponse;
import org.epde.tfm.common.response.RestResponse;
import org.epde.tfm.tasks.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    @GetMapping
    public RestResponse<List<TaskResponse>> all() {
        return RestResponse.success(200, "Fetched all tasks", service.getAll());
    }

    @GetMapping("/{id}")
    public RestResponse<TaskResponse> one(@PathVariable Long id) {
        return RestResponse.success(200, "Fetched task", service.getById(id));
    }

    @PostMapping
    public RestResponse<TaskResponse> create(@Valid @RequestBody TaskRequest dto) {
        return RestResponse.success(201, "Task created", service.create(dto));
    }

    @PutMapping("/{id}")
    public RestResponse<TaskResponse> update(@PathVariable Long id, @Valid @RequestBody TaskRequest dto) {
        return RestResponse.success(200, "Task updated", service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public RestResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return RestResponse.success(200, "Task deleted", null);
    }
}