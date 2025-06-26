package org.epde.tfm.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
    private String phone;
    private String position;
    private Long departmentId;
}
