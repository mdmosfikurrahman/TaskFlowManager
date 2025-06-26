package org.epde.tfm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.TaskDTO;
import org.epde.tfm.infrastructure.response.RestResponse;
import org.epde.tfm.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    @GetMapping
    public RestResponse<List<TaskDTO>> all() {
        return RestResponse.success(200, "Fetched all tasks", service.getAll());
    }

    @GetMapping("/{id}")
    public RestResponse<TaskDTO> one(@PathVariable Long id) {
        return RestResponse.success(200, "Fetched task", service.getById(id));
    }

    @PostMapping
    public RestResponse<TaskDTO> create(@Valid @RequestBody TaskDTO dto) {
        return RestResponse.success(201, "Task created", service.create(dto));
    }

    @DeleteMapping("/{id}")
    public RestResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return RestResponse.success(200, "Task deleted", null);
    }
}
