package org.epde.tfm.features.tasks.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequest {
    @NotBlank
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;
    private Long assignedToId;
    private Long projectId;
}
