package org.epde.tfm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    private User manager;
}
