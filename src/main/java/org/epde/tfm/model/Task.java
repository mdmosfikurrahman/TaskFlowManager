package org.epde.tfm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @ManyToOne
    private User assignedTo;
    @ManyToOne
    private Project project;
}
