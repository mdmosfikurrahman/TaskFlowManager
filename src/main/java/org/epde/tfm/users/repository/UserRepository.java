package org.epde.tfm.users.repository;

import org.epde.tfm.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
