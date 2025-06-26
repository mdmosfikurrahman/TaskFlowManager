package org.epde.tfm.features.users.repository;

import org.epde.tfm.features.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
