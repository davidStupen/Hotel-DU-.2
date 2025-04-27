
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Room room;
    private Guest guest;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private List<Guest> otherGuest = new ArrayList<>();

    public Booking(Room room, Guest guest, LocalDate checkIn, LocalDate checkOut, TypeOfVacation typeOfVacation) {
        this.room = room;
        this.guest = guest;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    public Booking(Room room, Guest guest){
        this(room, guest, LocalDate.now(), LocalDate.now().plusDays(6), TypeOfVacation.rekreacni);
    }
    public void addOtherGuest(Guest guest){
        otherGuest.add(guest);
    }
    public String printReservation(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String otherGuestBuild = "";
        for (Guest resN : otherGuest) {
            otherGuestBuild += resN.printDescription();
        }
        return "Rezervace od " + checkIn.format(formatter) + " do " + checkOut.format(formatter) + " na jméno " + getGuest().printDescription() + " " + otherGuestBuild;
    }
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public List<Guest> getOtherGuest() {
        return otherGuest;
    }

    public void setOtherGuest(List<Guest> otherGuest) {
        this.otherGuest = otherGuest;
    }
}
