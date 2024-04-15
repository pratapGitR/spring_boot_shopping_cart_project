package Store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Integer productTypeId;

    @Column(name = "Type_of_product")
    private String productType;

    @Column(name = "rate")
    private Double rateOfProduct;

    public ProductType() {

    }
}
