package annotatedEntity;

import org.springframework.context.annotation.Scope;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.util.Date.*;

public class BusBookingService {
    Scanner scanner = new Scanner(System.in);
    public void bookTicket() throws ParseException {
        //first we take person info
        System.out.println("Please enter person name: ");
        String personName = scanner.nextLine();
        System.out.println("Enter email, please: ");
        String personEmail = scanner.nextLine();
        System.out.println("Enter date of birth (yyyy-MM-dd)");
        String dateString = scanner.nextLine();
        Date dateOfBirth = SimpleDateFormat.getInstance().parse(dateString);


    }
}
