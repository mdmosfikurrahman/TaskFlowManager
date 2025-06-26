package org.epde.tfm.features.projects.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectRequest {
    @NotBlank
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long managerId;
}
