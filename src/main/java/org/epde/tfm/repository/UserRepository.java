package org.epde.tfm.repository;

import org.epde.tfm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
