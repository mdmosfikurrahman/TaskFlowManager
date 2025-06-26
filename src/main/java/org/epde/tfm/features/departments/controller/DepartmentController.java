package org.epde.tfm.features.departments.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.epde.tfm.features.departments.dto.request.DepartmentRequest;
import org.epde.tfm.features.departments.dto.response.DepartmentResponse;
import org.epde.tfm.common.response.RestResponse;
import org.epde.tfm.features.departments.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    @GetMapping
    public RestResponse<List<DepartmentResponse>> all() {
        return RestResponse.success(200, "Fetched all departments", service.getAll());
    }

    @GetMapping("/{id}")
    public RestResponse<DepartmentResponse> one(@PathVariable Long id) {
        return RestResponse.success(200, "Fetched department", service.getById(id));
    }

    @PostMapping
    public RestResponse<DepartmentResponse> create(@Valid @RequestBody DepartmentRequest dto) {
        return RestResponse.success(201, "Created", service.create(dto));
    }

    @PutMapping("/{id}")
    public RestResponse<DepartmentResponse> update(@PathVariable Long id, @Valid @RequestBody DepartmentRequest dto) {
        return RestResponse.success(200, "Updated", service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public RestResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return RestResponse.success(200, "Deleted", null);
    }
}