package org.epde.tfm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.ProjectDTO;
import org.epde.tfm.infrastructure.response.RestResponse;
import org.epde.tfm.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService service;

    @GetMapping
    public RestResponse<List<ProjectDTO>> all() {
        return RestResponse.success(200, "Fetched all projects", service.getAll());
    }

    @GetMapping("/{id}")
    public RestResponse<ProjectDTO> one(@PathVariable Long id) {
        return RestResponse.success(200, "Fetched project", service.getById(id));
    }

    @PostMapping
    public RestResponse<ProjectDTO> create(@Valid @RequestBody ProjectDTO dto) {
        return RestResponse.success(201, "Project created", service.create(dto));
    }

    @DeleteMapping("/{id}")
    public RestResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return RestResponse.success(200, "Project deleted", null);
    }
}
