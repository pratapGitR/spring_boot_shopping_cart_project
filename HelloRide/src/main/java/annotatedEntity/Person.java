package annotatedEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
@Entity
@Getter
@Setter
@Component
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    @SequenceGenerator(name = "person_sequence",sequenceName ="person_sequence", initialValue = 1001)
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_email")
    private String personEmail;

    @Column(name = "person_dob")
    private Date personDOB;

    @Column(name = "person_mobile")
    private Integer personMobile;

}
