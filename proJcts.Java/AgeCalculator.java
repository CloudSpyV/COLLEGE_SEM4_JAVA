import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user's birthdate
        System.out.print("Enter your birthdate (in yyyy-MM-dd format): ");
        String birthdateStr = scanner.nextLine();

        // Convert birthdate string to LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdate = LocalDate.parse(birthdateStr, formatter);

        // Calculate age based on current date
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthdate, currentDate);

        // Print age
        System.out.println("Your age is: " + age.getYears() + " years, " + age.getMonths() + " months, and "
                + age.getDays() + " days.");
        scanner.close();
    }

}
