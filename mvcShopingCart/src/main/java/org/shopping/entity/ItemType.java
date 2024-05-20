package org.shopping.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_types")
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_type_id")
    private Integer itemTypeId;
    @Column(name = "item_type_name")
    @NotBlank(message = "please provide item type")
    private String itemTypeName;
}
