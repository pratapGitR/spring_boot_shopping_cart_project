package Store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@Entity
@Table(name= "product")
public class Product {
    private String  productId;
    private String productName;
    private Double productQuantity;
    private String custId;
    private Integer productTypeId;
}
