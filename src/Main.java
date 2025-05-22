import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static StringBuilder fillBookings(BookingManager bookingManager){
        Guest dvorak1 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 5));
        Guest dvorak2 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1 ,3));
        Guest tmava = new Guest("Karolína", "Tmavá", LocalDate.of(2000, 11, 23));

        Room room1 = new Room(1, 1, new BigDecimal("1000"),true, true);
        Room room2 = new Room(2, 1, new BigDecimal("1000"),true, true);
        Room room3 = new Room(3, 3, new BigDecimal("2400"),false, true);

        Booking booking1 = new Booking(dvorak1, room3, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), TypeOfVacation.pracovni);
        Booking booking2 = new Booking(dvorak2, room2, LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7 ,21), TypeOfVacation.rekreacni);
        Booking booking3 = new Booking(tmava, room3, LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), TypeOfVacation.pracovni);
        bookingManager.addBooking(booking1);
        bookingManager.addBooking(booking2);
        bookingManager.addBooking(booking3);
        booking3.addOtherGuest(dvorak1);
        for (int i = 0; i < 10; i ++) {
            Booking bookingLoop = new Booking(tmava, room2, LocalDate.of(2023, 8, i + 1 + i), LocalDate.of(2023, 8, i + 2 + i), TypeOfVacation.rekreacni);
            bookingManager.addBooking(bookingLoop);
        }
        StringBuilder reservations = new StringBuilder();
        bookingManager.getBookings().forEach(item -> {
            reservations.append(item.getFormattedSummary()).append("\n");
        });
        return reservations;
    }
    public static void main(String[] args){
        BookingManager bookingManager = new BookingManager();
        StringBuilder formattedOutputOfAllBookings = fillBookings(bookingManager);
        int numOfWorkBookings = bookingManager.getNumberOfWorkingBookings();

        System.out.println("Počet pracovních pobytů: " + numOfWorkBookings);

        System.out.println("Průměrný počet hostů na rezervaci: " + bookingManager.getAverageGuests());
        System.out.println();
        System.out.println("Prvních osm rekreačních rezervací:");
        System.out.println(bookingManager.getTopNHolidayBookings());
        bookingManager.printGuestStatistics();
        System.out.println();
        System.out.println("Počet pracovních pobytů: " + numOfWorkBookings);
        System.out.println();
        System.out.println(formattedOutputOfAllBookings);
        System.out.println("****************//////////////********************");
        System.out.println(bookingManager.getBooking(-5));
        bookingManager.clearBookings();

    }
}