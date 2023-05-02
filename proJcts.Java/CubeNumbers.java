import java.util.Scanner;

public class CubeNumbers {
   public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      System.out.print("Input number of terms: ");
      int num = input.nextInt();

      for (int i = 1; i <= num; i++) {
         System.out.println("Number is : " + i + " and cube of " + i + " is : " + (i * i * i));
      }
      input.close();
   }
}
