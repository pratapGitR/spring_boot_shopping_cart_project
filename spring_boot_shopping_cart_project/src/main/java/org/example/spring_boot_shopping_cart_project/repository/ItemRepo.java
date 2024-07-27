package org.example.spring_boot_shopping_cart_project.repository;

import org.example.spring_boot_shopping_cart_project.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
}
