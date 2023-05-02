import java.util.Arrays;
import java.util.Scanner;

public class DiskScheduling {
    public static void main(String[] args) {
        int n, head, total_seek_time = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disk requests: ");
        n = scanner.nextInt();
        int[] requests = new int[n];
        System.out.print("Enter the requests: ");
        for (int i = 0; i < n; i++) {
            requests[i] = scanner.nextInt();
        }
        System.out.print("Enter the initial head position: ");
        head = scanner.nextInt();
        // sort the requests in ascending order
        Arrays.sort(requests);
        // find the index of the initial head position in the sorted list
        int initial_index = 0;
        for (int i = 0; i < n; i++) {
            if (requests[i] == head) {
                initial_index = i;
                break;
            }
        }
        // handle the requests to the right of the initial head position
        for (int i = initial_index; i < n; i++) {
            total_seek_time += Math.abs(requests[i] - head);
            head = requests[i];
        }
        // handle the requests to the left of the initial head position
        for (int i = initial_index - 1; i >= 0; i--) {
            total_seek_time += Math.abs(requests[i] - head);
            head = requests[i];
        }
        System.out.println("Total seek time: " + total_seek_time);
    }
}
