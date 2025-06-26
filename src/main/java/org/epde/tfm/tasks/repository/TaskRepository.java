package org.epde.tfm.tasks.repository;

import org.epde.tfm.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
