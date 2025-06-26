package org.epde.tfm.features.departments.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentRequest {
    @NotBlank
    private String name;
    private String code;
    private String location;
}

