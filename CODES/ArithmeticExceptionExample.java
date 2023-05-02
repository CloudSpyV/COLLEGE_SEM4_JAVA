import java.util.Scanner;

public class ArithmeticExceptionExample {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num1 = scanner.nextInt();
    System.out.print("Enter another number: ");
    int num2 = scanner.nextInt();
    scanner.close();

    try {
      int result = num1 / num2;
      System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
      System.out.println("Error: Division by zero is not allowed.");
    }
  }
}
