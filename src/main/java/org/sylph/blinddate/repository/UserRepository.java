package org.sylph.blinddate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sylph.blinddate.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}