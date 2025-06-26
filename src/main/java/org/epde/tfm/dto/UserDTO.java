package org.epde.tfm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    @NotBlank
    private String name;
    @Email
    private String email;
    private Long departmentId;
}
