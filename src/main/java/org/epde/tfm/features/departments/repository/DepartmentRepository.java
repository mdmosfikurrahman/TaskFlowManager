package org.epde.tfm.features.departments.repository;

import org.epde.tfm.features.departments.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

