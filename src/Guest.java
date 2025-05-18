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
    public DateTimeFormatter formatDate(){
        return DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }
    public LocalDate getBorn(){
        return born;
    }
}
