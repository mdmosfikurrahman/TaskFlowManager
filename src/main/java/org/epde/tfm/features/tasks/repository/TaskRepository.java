package org.epde.tfm.features.tasks.repository;

import org.epde.tfm.features.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
