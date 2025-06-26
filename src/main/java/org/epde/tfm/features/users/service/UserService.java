package org.epde.tfm.features.users.service;

import org.epde.tfm.features.users.dto.request.UserRequest;
import org.epde.tfm.features.users.dto.response.UserResponse;

import java.util.List;


public interface UserService {
    List<UserResponse> getAll();
    UserResponse getById(Long id);
    UserResponse create(UserRequest dto);
    UserResponse update(Long id, UserRequest dto);
    void delete(Long id);
}