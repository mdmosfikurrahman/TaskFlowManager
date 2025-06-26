package org.epde.tfm.projects.repository;

import org.epde.tfm.projects.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
