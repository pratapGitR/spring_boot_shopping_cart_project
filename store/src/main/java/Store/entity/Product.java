package Store.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@Entity
@Table(name= "product")
public class Product {
    @Id
    @Column(name="product_id")
    private String  productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name="product_quantity")
    private Double productQuantity;
    @ManyToOne
    @JoinColumn (name = "cust_Id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="product_type_id")
    private ProductType productTypeId;

}
