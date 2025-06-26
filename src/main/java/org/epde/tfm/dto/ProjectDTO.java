package org.epde.tfm.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectDTO {
    private Long id;
    @NotBlank
    private String name;
    private Long managerId;
}
