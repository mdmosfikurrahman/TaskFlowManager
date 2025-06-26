package org.epde.tfm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskDTO {
    private Long id;
    @NotBlank
    private String title;
    private Long assignedToId;
    private Long projectId;
}
