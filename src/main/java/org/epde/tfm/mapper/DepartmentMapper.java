package org.epde.tfm.mapper;

import org.epde.tfm.dto.DepartmentDTO;
import org.epde.tfm.model.Department;

public class DepartmentMapper {
    public static DepartmentDTO toDto(Department e) {
        DepartmentDTO d = new DepartmentDTO();
        d.setId(e.getId());
        d.setName(e.getName());
        return d;
    }

    public static Department toEntity(DepartmentDTO d) {
        Department e = new Department();
        e.setId(d.getId());
        e.setName(d.getName());
        return e;
    }
}


