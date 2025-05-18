import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BookingManager extends Booking{
    private List<Booking> bookingList = new ArrayList<>();
    private static int totalWorkVacation;

    public void addBooking(Booking booking){
        bookingList.add(booking);
    }
    public String getBooking(int index){
        return (index < 0) ? "Zadal jsi záporný index. Prosíme ať už se to neopakuje!! 😡" : bookingList.get(index).getFormattedSummary();
    }
    public List<Booking> getBookings(){
        return bookingList;
    }
    public void clearBookings(){
        bookingList.clear();
    }
    public int getNumberOfWorkingBookings(){
        bookingList.forEach(item -> {
            if (item.getTypeOfVacation() == TypeOfVacation.pracovni) totalWorkVacation++;
        });
        return totalWorkVacation;
    }
    public String getAverageGuests(){
        double mathAverage = (double) totalGuestInSystem / getBookings().size();
        double average = BigDecimal.valueOf(mathAverage).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return "\nPrůměrný počet hostů na rezervaci: " + average + "\n";
    }
    public StringBuilder getTopNHolidayBookings(){
        int count = 0;
        StringBuilder buildEightVacation = new StringBuilder();
        for (Booking oneBooking : bookingList) {
            if (oneBooking.getTypeOfVacation() == TypeOfVacation.rekreacni && count < 8) {
                count++;
                buildEightVacation.append(oneBooking.getGuest().getFullName()).append(" ").append("(").append(oneBooking.getGuest().getBorn().format(oneBooking.getGuest().formatDate())).append(") ")
                        .append("na: ").append(oneBooking.getRoom().getNumRoom()).append(" Termín: ").append(oneBooking.getCheckIn().format(oneBooking.getGuest().formatDate())).append(" - ")
                        .append(oneBooking.getCheckOut().format(oneBooking.getGuest().formatDate())).append(" pracovní pobyt: ").append((oneBooking.getTypeOfVacation() == TypeOfVacation.pracovni) ? "ano" : "ne").append("\n");
            }
        }
        return buildEightVacation;
    }
    public void printGuestStatistics(){
        int oneGuest = 0;
        int twoGuest = 0;
        int moreThanTwoGuest = 0;
        for (Booking oneBooking : bookingList){
            if (oneBooking.getGuestsCount() == 1) oneGuest++;
            if (oneBooking.getGuestsCount() == 2) twoGuest++;
            if (oneBooking.getGuestsCount() > 2) moreThanTwoGuest++;
        }
        System.out.printf("Statistiky hostů:\nPočet rezervací s jedním hostem: %d\nPočet rezervací se dvěma hosty: %d\nPočet rezervací s více hosty: %d\n\n", oneGuest, twoGuest, moreThanTwoGuest);
    }
}
