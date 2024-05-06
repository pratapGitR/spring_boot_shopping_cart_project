package annotatedEntity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "annotatedEntity")

public class AnnotationConfig {
    @Bean
    public Person person(){
        Person person = new Person();
        return person;
    }
    @Bean
    public BusInfo busInfo(){
        BusInfo busInfo = new BusInfo();
        return busInfo;
    }
    @Bean
    public TicketInfo ticketInfo(){
        TicketInfo ticketInfo = new TicketInfo();
        return ticketInfo;
    }
}
