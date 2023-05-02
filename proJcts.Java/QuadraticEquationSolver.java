import java.util.Scanner;

public class QuadraticEquationSolver {

   public static void main(String[] args) {

      double a, b, c, discriminant, root1, root2;

      Scanner input = new Scanner(System.in);

      System.out.print("Input a: ");
      a = input.nextDouble();

      System.out.print("Input b: ");
      b = input.nextDouble();

      System.out.print("Input c: ");
      c = input.nextDouble();

      discriminant = b * b - 4 * a * c;

      if (discriminant > 0) {
         root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
         root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
         System.out.println("The roots are " + root1 + " and " + root2);
      } else if (discriminant == 0) {
         root1 = -b / (2 * a);
         System.out.println("The root is " + root1);
      } else {
         System.out.println("The equation has no real roots");
      }
      input.close();
   }
}
