import java.util.Scanner;

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        int[] burstTime = new int[n];
        int[] remainingTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int quantum;

        System.out.println("Enter burst time for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
            remainingTime[i] = burstTime[i];
        }

        System.out.print("Enter time quantum: ");
        quantum = sc.nextInt();

        int time = 0;
        while (true) {
            boolean done = true;

            for (int i = 0; i < n; i++) {
                if (remainingTime[i] > 0) {
                    done = false;

                    if (remainingTime[i] > quantum) {
                        time += quantum;
                        remainingTime[i] -= quantum;
                    } else {
                        time += remainingTime[i];
                        waitingTime[i] = time - burstTime[i];
                        remainingTime[i] = 0;
                    }
                }
            }

            if (done == true) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = burstTime[i] + waitingTime[i];
        }

        System.out.println("\nRound Robin Scheduling Table:");
        System.out.println("-------------------------------------------------");
        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.println(
                    "P" + (i + 1) + "\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }

        System.out.println("-------------------------------------------------");

        float totalWaitingTime = 0;
        float totalTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / n));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / n));
        sc.close();
    }

}
