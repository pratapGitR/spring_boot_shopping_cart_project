package org.example.spring_boot_shopping_cart_project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "item_types")
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_type_id")
    private Integer itemTypeId;
    @Column(name = "item_type_name")
    private String itemTypeName;
    @OneToMany(mappedBy="itemType")
    private List<Item>items;
}
