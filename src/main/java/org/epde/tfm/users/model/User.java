package org.epde.tfm.users.model;

import jakarta.persistence.*;
import lombok.*;
import org.epde.tfm.departments.model.Department;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String position;

    @ManyToOne
    private Department department;
}
