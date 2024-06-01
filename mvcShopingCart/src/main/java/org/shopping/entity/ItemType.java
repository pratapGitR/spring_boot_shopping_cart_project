package org.shopping.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
}
