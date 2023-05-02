public class ThrowsExample {
  public static void main(String[] args) {
    try {
      int result = divide(10, 0);
      System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static int divide(int num1, int num2) throws ArithmeticException {
    if (num2 == 0) {
      throw new ArithmeticException("Division by zero is not allowed.");
    }
    return num1 / num2;
  }
}
