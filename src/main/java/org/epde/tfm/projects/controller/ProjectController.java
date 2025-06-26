package org.epde.tfm.projects.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.epde.tfm.projects.dto.request.ProjectRequest;
import org.epde.tfm.projects.dto.response.ProjectResponse;
import org.epde.tfm.common.response.RestResponse;
import org.epde.tfm.projects.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService service;

    @GetMapping
    public RestResponse<List<ProjectResponse>> all() {
        return RestResponse.success(200, "Fetched all projects", service.getAll());
    }

    @GetMapping("/{id}")
    public RestResponse<ProjectResponse> one(@PathVariable Long id) {
        return RestResponse.success(200, "Fetched project", service.getById(id));
    }

    @PostMapping
    public RestResponse<ProjectResponse> create(@Valid @RequestBody ProjectRequest dto) {
        return RestResponse.success(201, "Project created", service.create(dto));
    }

    @PutMapping("/{id}")
    public RestResponse<ProjectResponse> update(@PathVariable Long id, @Valid @RequestBody ProjectRequest dto) {
        return RestResponse.success(200, "Project updated", service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public RestResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return RestResponse.success(200, "Project deleted", null);
    }
}