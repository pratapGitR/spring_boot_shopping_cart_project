package org.pratap.spring_security_jwt.repository;

import org.pratap.spring_security_jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User>findByName(String name);
    Optional<User> findByEmail(String email); // <email, user>
}
