package annotatedEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@Table(name = "BusInfo")
@Component
public class BusInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bus_sequence")
    @SequenceGenerator(name = "bus_sequence", sequenceName = "bus_sequence",initialValue = 201)
    @Column(name = "bus_id")
    private int busId;

    @Column(name = "bus_type")
    private String busType;

    @Column(name = "bus_service_provider")
    private String busServiceProvider;

    @Column(name = "no_of_seat")
    private int noOfSeats;
}
