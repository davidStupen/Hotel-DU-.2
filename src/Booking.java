import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Room room;
    private Guest guest;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private List<Guest> otherGuests = new ArrayList<>();
    private TypeOfVacation typeOfVacation;
    protected static int totalGuestInSystem;

    public Booking(Guest guest, Room room, LocalDate checkIn, LocalDate checkOut, TypeOfVacation typeOfVacation) {
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.typeOfVacation = typeOfVacation;
    }
    public Booking(Guest guest, Room room){
        this(guest, room, LocalDate.now(), LocalDate.now().plusDays(6), TypeOfVacation.rekreacni);
    }
    public Booking(){}
    public void addOtherGuest(Guest guest){
        otherGuests.add(guest);
    }
    public String getFormattedSummary(){
        return checkIn.format(guest.formatDate()) + " až " + checkOut.format(guest.formatDate()) + ": " + guest.getFullName() +
                "(" + guest.getBorn().format(guest.formatDate()) + ")" +
                "[" + (getGuestsCount()) + ", " + (room.isHaveSeaView() ? "ano" : "ne") + "] za " + getTotalPrice() + "Kč.";
    }
    public int getGuestsCount() {
        totalGuestInSystem += 1 + otherGuests.size();
        return 1 + otherGuests.size();
    }
    public int getBookingLength(){
        return Period.between(checkIn, checkOut).getDays();
    }
    public BigDecimal getTotalPrice(){
        return BigDecimal.valueOf(getBookingLength()).multiply(room.getPrice());
    }
    public Guest getGuest() {
        return guest;
    }
    public TypeOfVacation getTypeOfVacation(){
        return typeOfVacation;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }
}
