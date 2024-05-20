package org.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.Pos;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items_info")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;
    @NotBlank(message = "Please provide item name !")
    private String itemName;
    @Column(name = "item_quantity")
    @NotNull(message = "please provide item quantity")
    @Positive(message = "item can not be negative ")
    private Integer itemQuantity;
    @Column(name = "item_price")
    @NotNull(message = "please provide item price")
    @Positive(message = "item price can not be negative.")
    private Double itemPrice;
    @Column(name="item_type")
    @NotBlank(message = "please provide item type")
    @ManyToOne
    @JoinColumn(name="item_type_id")
    private ItemType itemType;
}
