import java.util.Scanner;

public class DiskScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of disk requests: ");
        int n = scanner.nextInt();
        int[] requests = new int[n];

        System.out.print("Enter the requests: ");
        for (int i = 0; i < n; i++) {
            requests[i] = scanner.nextInt();
        }

        System.out.print("Enter the initial head position: ");
        int head = scanner.nextInt();

        int totalSeekTime = Math.abs(head - requests[0]);
        for (int i = 1; i < n; i++) {
            totalSeekTime += Math.abs(requests[i] - requests[i - 1]);
        }

        System.out.println("Total seek time: " + totalSeekTime);
    }
}
