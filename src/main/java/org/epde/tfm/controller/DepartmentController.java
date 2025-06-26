package org.epde.tfm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.DepartmentDTO;
import org.epde.tfm.infrastructure.response.RestResponse;
import org.epde.tfm.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    @GetMapping
    public RestResponse<List<DepartmentDTO>> all() {
        return RestResponse.success(200, "Fetched all departments", service.getAll());
    }

    @GetMapping("/{id}")
    public RestResponse<DepartmentDTO> one(@PathVariable Long id) {
        return RestResponse.success(200, "Fetched department", service.getById(id));
    }

    @PostMapping
    public RestResponse<DepartmentDTO> create(@Valid @RequestBody DepartmentDTO dto) {
        return RestResponse.success(201, "Department created", service.create(dto));
    }

    @DeleteMapping("/{id}")
    public RestResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return RestResponse.success(200, "Department deleted", null);
    }
}
