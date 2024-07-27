package org.example.spring_boot_shopping_cart_project.repository;

import org.example.spring_boot_shopping_cart_project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
