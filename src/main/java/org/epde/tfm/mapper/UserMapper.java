package org.epde.tfm.mapper;

import org.epde.tfm.dto.request.UserRequest;
import org.epde.tfm.dto.response.UserResponse;
import org.epde.tfm.model.Department;
import org.epde.tfm.model.User;


public class UserMapper {
    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .position(user.getPosition())
                .departmentName(user.getDepartment() != null ? user.getDepartment().getName() : null)
                .build();
    }

    public static User toEntity(UserRequest dto, Department dept) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .position(dto.getPosition())
                .department(dept)
                .build();
    }
}