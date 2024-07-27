package org.example.spring_boot_shopping_cart_project.repository;

import org.example.spring_boot_shopping_cart_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByUserEmail(String userEmail);
    @Query(value = "SELECT u.* FROM user u JOIN user_roles ur ON u.userId = ur.user_id JOIN role r ON ur.role_id = r.roleId WHERE r.roleName like :role", nativeQuery = true)
    List<User>findByRolesName(@Param("role") String role);

   @Transactional
   @Modifying
    @Query(value = "DELETE FROM user WHERE userName = :userName", nativeQuery = true)
    void deleteByUserName(String userName);
}

