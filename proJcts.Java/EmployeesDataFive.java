import java.util.Scanner;

public class EmployeesDataFive {
    /**
     * @param args
     * @param string TODO
     */
    public static void main(String[] args, String string) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the deatils in order");
        System.out.println("Name,Mail,EmpCode,Phone");
        String[] name = new String[5];
        String[] mail = new String[5];
        String[] empc = new String[5];
        String[] ph = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details of EMPLOYEE " + (i + 1));
            name[i] = sc.nextLine();
            mail[i] = sc.nextLine();
            empc[i] = sc.nextLine();
            ph[i] = sc.nextLine();
        }
        System.out.println("Name\tMail\tEmpCode\tPhone");
        for (int i = 0; i < 5; i++) {

            System.out.println(name[i] + "\t" + mail[i] + "\t" + empc[i] + "\t" + ph[i]);
        }
        sc.close();
    }
}
