import java.util.Scanner;

public class Voting_sys {
    public static void main(String args[]) {
        int population;
        System.out.println("Enter the amount of Expected population for voting: ");
        Scanner sc = new Scanner(System.in);
        population = sc.nextInt();

        int a = 0, b = 0, c = 0, d = 0, e = 0;
        int count[] = { a, b, c, d, e };
        int y = 0;
        int spoiled_count = 0;

        for (int x = 0; x < population; ++x) {
            System.out.println(
                    "\nPress 1. For first Candidate\nPress 2. For Second Candidate\nPress 3. For third Candidate\nPress 4. For fourth Candidate\nPress 5. For fifth Candidate");
            y = sc.nextInt();

            switch (y) {
                case 1: {
                    count[0]++;
                    break;
                }
                case 2: {
                    count[1]++;
                    break;
                }
                case 3: {
                    count[2]++;
                    break;
                }
                case 4: {
                    count[3]++;
                    break;
                }
                case 5: {
                    count[4]++;
                    break;
                }
                default: {
                    spoiled_count++;
                    break;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("\tThe votes for " + (i + 1) + " candidate is: " + count[i]);
        }

        System.out.println("\nSpoiled Ballets are: " + spoiled_count);
        sc.close();
    }

}