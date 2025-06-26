package org.epde.tfm.mapper;

import org.epde.tfm.dto.request.DepartmentRequest;
import org.epde.tfm.dto.response.DepartmentResponse;
import org.epde.tfm.model.Department;

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
