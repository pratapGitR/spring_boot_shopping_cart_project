package annotatedEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@Table(name = "Ticket_Info")
@Component
public class TicketInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;

    @Column(name = "ticket_type")
    private String ticketType;

    @Column(name = "date_of_ticket")
    private String dateOfTicket;

    @Autowired
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @Autowired
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bus_id")
    private BusInfo busInfo;
}
