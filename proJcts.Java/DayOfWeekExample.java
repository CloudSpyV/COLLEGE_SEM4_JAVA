import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DayOfWeekExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        scanner.close();

        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        System.out.println("Day of the week: " + dayOfWeek);
    }
}
