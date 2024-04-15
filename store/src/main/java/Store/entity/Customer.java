package Store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private String custId;
    @Column(name = "customer_name", length=55)
    private String custName;
    @Column(name= "customer_email")
    private String customerEmail;
    @Column(name = "customer_mobile" ,length=10)
    private Long custMob;
    @Column(name = "final_product_price")
    private Double finalProductPrice;
}
