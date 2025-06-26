package org.epde.tfm.controller.graphql;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.request.UserRequest;
import org.epde.tfm.dto.response.UserResponse;
import org.epde.tfm.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserGraphQLController {
    private final UserService service;

    @QueryMapping
    public List<UserResponse> getUsers() {
        return service.getAll();
    }

    @QueryMapping
    public UserResponse getUserById(@Argument Long id) {
        return service.getById(id);
    }

    @MutationMapping
    public UserResponse createUser(@Argument UserRequest input) {
        return service.create(input);
    }

    @MutationMapping
    public UserResponse updateUser(@Argument Long id, @Argument UserRequest input) {
        return service.update(id, input);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Long id) {
        service.delete(id);
        return true;
    }
}
