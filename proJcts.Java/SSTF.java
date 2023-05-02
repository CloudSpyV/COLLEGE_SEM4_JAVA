import java.util.Scanner;

public class DiskScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of disk requests: ");
        int n = scanner.nextInt();
        int[] requests = new int[n];
        int[] visited = new int[n];

        System.out.print("Enter the requests: ");
        for (int i = 0; i < n; i++) {
            requests[i] = scanner.nextInt();
            visited[i] = 0; // initialize all requests as unvisited
        }

        System.out.print("Enter the initial head position: ");
        int head = scanner.nextInt();
        int totalSeekTime = 0;

        for (int i = 0; i < n; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;

            // find the request with the shortest seek time from the current head position
            for (int j = 0; j < n; j++) {
                if (visited[j] == 0) {
                    int distance = Math.abs(head - requests[j]);
                    if (distance < minDistance) {
                        minDistance = distance;
                        minIndex = j;
                    }
                }
            }

            visited[minIndex] = 1; // mark the selected request as visited
            totalSeekTime += minDistance; // add the seek time to the total
            head = requests[minIndex]; // update the head position
        }

        System.out.println("Total seek time: " + totalSeekTime);
    }
}
