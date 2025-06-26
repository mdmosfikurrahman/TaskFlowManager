package org.epde.tfm.service;

import org.epde.tfm.dto.request.DepartmentRequest;
import org.epde.tfm.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponse> getAll();
    DepartmentResponse getById(Long id);
    DepartmentResponse create(DepartmentRequest dto);
    DepartmentResponse update(Long id, DepartmentRequest dto);
    void delete(Long id);
}


