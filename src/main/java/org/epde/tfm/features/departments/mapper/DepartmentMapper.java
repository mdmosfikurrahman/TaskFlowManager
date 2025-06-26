package org.epde.tfm.features.departments.mapper;

import org.epde.tfm.features.departments.dto.request.DepartmentRequest;
import org.epde.tfm.features.departments.dto.response.DepartmentResponse;
import org.epde.tfm.features.departments.model.Department;

public class DepartmentMapper {

    public static DepartmentResponse toResponse(Department department) {
        return DepartmentResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .code(department.getCode())
                .location(department.getLocation())
                .build();
    }

    public static Department toEntity(DepartmentRequest request) {
        return Department.builder()
                .name(request.getName())
                .code(request.getCode())
                .location(request.getLocation())
                .build();
    }
}
