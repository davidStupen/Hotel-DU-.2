import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {
    private String firstName;
    private String lastName;
    private LocalDate born;

    public Guest(String firstName, String lastName, LocalDate born){
        this.firstName = firstName;
        this.lastName = lastName;
        this.born = born;
    }
    public String printDescription(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return firstName + " " + lastName + " (" + born.format(formatter) + ").";
    }
    public String getDescription(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return firstName + " " + lastName + " " + born.format(formatter);
    }
    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
