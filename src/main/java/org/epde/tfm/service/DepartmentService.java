package org.epde.tfm.service;

import org.epde.tfm.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDTO> getAll();

    DepartmentDTO getById(Long id);

    DepartmentDTO create(DepartmentDTO dto);

    void delete(Long id);
}


