package org.epde.tfm.departments.repository;

import org.epde.tfm.departments.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

