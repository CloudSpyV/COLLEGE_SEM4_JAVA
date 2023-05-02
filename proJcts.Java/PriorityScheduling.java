import java.util.*;

public class PriorityScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] priority = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1) + ":");
            System.out.print("  Arrival time: ");
            arrivalTime[i] = sc.nextInt();
            System.out.print("  Burst time: ");
            burstTime[i] = sc.nextInt();
            System.out.print("  Priority: ");
            priority[i] = sc.nextInt();
        }

        int totalTime = 0;
        int currentProcess = -1;
        int[] completionTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];

        while (true) {
            int highestPriority = Integer.MAX_VALUE;
            int highestPriorityProcess = -1;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && arrivalTime[i] <= totalTime && priority[i] < highestPriority) {
                    highestPriority = priority[i];
                    highestPriorityProcess = i;
                }
            }

            if (highestPriorityProcess == -1) {
                break;
            }

            visited[highestPriorityProcess] = true;
            currentProcess = highestPriorityProcess;

            completionTime[currentProcess] = totalTime + burstTime[currentProcess];
            turnaroundTime[currentProcess] = completionTime[currentProcess] - arrivalTime[currentProcess];
            waitingTime[currentProcess] = turnaroundTime[currentProcess] - burstTime[currentProcess];

            totalTime += burstTime[currentProcess];
        }

        double totalTurnaroundTime = 0;
        double totalWaitingTime = 0;

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Process", "Arrival Time", "Burst Time", "Priority",
                "Completion Time", "Turnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15d%-15d%-15d%-15d%-15d%-15d\n", (i + 1), arrivalTime[i], burstTime[i], priority[i],
                    completionTime[i], turnaroundTime[i]);
            totalTurnaroundTime += turnaroundTime[i];
            totalWaitingTime += waitingTime[i];
        }

        System.out.println("\nAverage Turnaround Time: " + (totalTurnaroundTime / n));
        System.out.println("Average Waiting Time: " + (totalWaitingTime / n));
    }
}
