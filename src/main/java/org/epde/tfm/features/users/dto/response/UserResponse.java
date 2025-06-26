package org.epde.tfm.features.users.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String position;
    private String departmentName;
}
