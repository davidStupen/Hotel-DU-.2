import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Guest adela = new Guest("Adéla", "Maliková", LocalDate.of(1993, 3, 13));
        Guest jana = new Guest("Jana", "Dvořečková", LocalDate.of(1995, 5, 5));
        Guest ferda = new Guest("Ferda", "Mravenec", LocalDate.of(2006, 8, 12));
        jana.setBorn(LocalDate.of(1995, 4, 5));
        System.out.println(jana.printDescription());
        System.out.println("************************");
        Room room1 = new Room(1, 1, new BigDecimal("1000"),true, true);
        Room room2 = new Room(2, 1, new BigDecimal("1000"),true, true);
        Room room3 = new Room(3, 3, new BigDecimal("2400"),false, true);

        List<Booking> bookingList = new ArrayList<>();
        Booking singleBooking = new Booking(room1, adela, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), TypeOfVacation.rekreacni);
        Booking groupBooking = new Booking(room3, jana, LocalDate.of(2021, 9, 3), LocalDate.of(2021, 9, 14), TypeOfVacation.rekreacni);
        Booking ferdaBooking = new Booking(room2, ferda);

        bookingList.add(singleBooking);

        bookingList.add(groupBooking);
        groupBooking.addOtherGuest(adela);

        bookingList.add(ferdaBooking);

        bookingList.forEach(item -> {
            System.out.println();
            System.out.println(item.printReservation());
            System.out.println("//*******//////*******//");
        });

    }
}