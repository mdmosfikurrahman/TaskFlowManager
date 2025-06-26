package org.epde.tfm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentDTO {
    private Long id;
    @NotBlank
    private String name;
}
