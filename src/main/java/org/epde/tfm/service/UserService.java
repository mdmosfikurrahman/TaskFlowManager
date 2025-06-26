package org.epde.tfm.service;

import org.epde.tfm.dto.request.UserRequest;
import org.epde.tfm.dto.response.UserResponse;

import java.util.List;


public interface UserService {
    List<UserResponse> getAll();
    UserResponse getById(Long id);
    UserResponse create(UserRequest dto);
    UserResponse update(Long id, UserRequest dto);
    void delete(Long id);
}