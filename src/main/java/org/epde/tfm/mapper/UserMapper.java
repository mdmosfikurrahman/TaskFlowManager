package org.epde.tfm.mapper;

import org.epde.tfm.dto.UserDTO;
import org.epde.tfm.model.Department;
import org.epde.tfm.model.User;

public class UserMapper {
    public static UserDTO toDto(User e) {
        UserDTO d = new UserDTO();
        d.setId(e.getId());
        d.setName(e.getName());
        d.setEmail(e.getEmail());
        d.setDepartmentId(e.getDepartment() != null ? e.getDepartment().getId() : null);
        return d;
    }

    public static User toEntity(UserDTO d, Department dept) {
        User e = new User();
        e.setId(d.getId());
        e.setName(d.getName());
        e.setEmail(d.getEmail());
        e.setDepartment(dept);
        return e;
    }
}
