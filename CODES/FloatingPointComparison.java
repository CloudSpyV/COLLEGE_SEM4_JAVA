import java.util.Scanner;

public class FloatingPointComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a floating-point number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter another floating-point number: ");
        double num2 = scanner.nextDouble();
        scanner.close();

        if (Math.abs(num1 - num2) < 0.001) {
            System.out.println("The two numbers are the same up to three decimal places.");
        } else {
            System.out.println("The two numbers are not the same up to three decimal places.");
        }
    }
}
