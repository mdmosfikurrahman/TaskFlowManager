package org.epde.tfm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.UserDTO;
import org.epde.tfm.infrastructure.response.RestResponse;
import org.epde.tfm.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @GetMapping
    public RestResponse<List<UserDTO>> all() {
        return RestResponse.success(200, "Fetched all users", service.getAll());
    }

    @GetMapping("/{id}")
    public RestResponse<UserDTO> one(@PathVariable Long id) {
        return RestResponse.success(200, "Fetched user", service.getById(id));
    }

    @PostMapping
    public RestResponse<UserDTO> create(@Valid @RequestBody UserDTO dto) {
        return RestResponse.success(201, "User created", service.create(dto));
    }

    @DeleteMapping("/{id}")
    public RestResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return RestResponse.success(200, "User deleted", null);
    }
}
