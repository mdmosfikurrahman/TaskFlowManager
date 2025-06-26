package org.epde.tfm.controller.graphql;

import lombok.RequiredArgsConstructor;
import org.epde.tfm.dto.request.DepartmentRequest;
import org.epde.tfm.dto.response.DepartmentResponse;
import org.epde.tfm.service.DepartmentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartmentGraphQLController {
    private final DepartmentService service;

    @QueryMapping
    public List<DepartmentResponse> getDepartments() {
        return service.getAll();
    }

    @QueryMapping
    public DepartmentResponse getDepartmentById(@Argument Long id) {
        return service.getById(id);
    }

    @MutationMapping
    public DepartmentResponse createDepartment(@Argument DepartmentRequest input) {
        return service.create(input);
    }

    @MutationMapping
    public DepartmentResponse updateDepartment(@Argument Long id, @Argument DepartmentRequest input) {
        return service.update(id, input);
    }

    @MutationMapping
    public Boolean deleteDepartment(@Argument Long id) {
        service.delete(id);
        return true;
    }
}
