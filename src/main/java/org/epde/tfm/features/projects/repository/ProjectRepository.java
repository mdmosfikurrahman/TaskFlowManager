package org.epde.tfm.features.projects.repository;

import org.epde.tfm.features.projects.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
