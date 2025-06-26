package org.epde.tfm.features.projects.model;

import jakarta.persistence.*;
import lombok.*;
import org.epde.tfm.features.users.model.User;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private User manager;
}
