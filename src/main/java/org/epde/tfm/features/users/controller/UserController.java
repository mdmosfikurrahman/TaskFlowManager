package org.epde.tfm.features.users.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.epde.tfm.features.users.dto.request.UserRequest;
import org.epde.tfm.features.users.dto.response.UserResponse;
import org.epde.tfm.common.response.RestResponse;
import org.epde.tfm.features.users.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @GetMapping
    public RestResponse<List<UserResponse>> all() {
        return RestResponse.success(200, "Fetched all users", service.getAll());
    }

    @GetMapping("/{id}")
    public RestResponse<UserResponse> one(@PathVariable Long id) {
        return RestResponse.success(200, "Fetched user", service.getById(id));
    }

    @PostMapping
    public RestResponse<UserResponse> create(@Valid @RequestBody UserRequest dto) {
        return RestResponse.success(201, "User created", service.create(dto));
    }

    @PutMapping("/{id}")
    public RestResponse<UserResponse> update(@PathVariable Long id, @Valid @RequestBody UserRequest dto) {
        return RestResponse.success(200, "User updated", service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public RestResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return RestResponse.success(200, "User deleted", null);
    }
}