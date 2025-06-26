package org.epde.tfm.tasks.model;

import jakarta.persistence.*;
import lombok.*;
import org.epde.tfm.users.model.User;
import org.epde.tfm.projects.model.Project;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;

    @ManyToOne
    private User assignedTo;

    @ManyToOne
    private Project project;
}
