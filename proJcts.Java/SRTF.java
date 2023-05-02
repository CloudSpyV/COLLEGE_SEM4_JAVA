import java.util.Scanner;

public class SRTF {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        int[] burstTime = new int[n];
        int[] remainingTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int shortestJob = 0;
        int time = 0;
        int totalTime = 0;

        System.out.println("Enter burst time for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
            remainingTime[i] = burstTime[i];
            totalTime += burstTime[i];
        }

        while (time < totalTime) {
            int minTime = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (remainingTime[i] > 0 && remainingTime[i] < minTime) {
                    minTime = remainingTime[i];
                    shortestJob = i;
                }
            }

            remainingTime[shortestJob]--;

            if (remainingTime[shortestJob] == 0) {
                turnaroundTime[shortestJob] = time + 1 - burstTime[shortestJob];
                waitingTime[shortestJob] = turnaroundTime[shortestJob] - burstTime[shortestJob];
            }

            time++;
        }

        System.out.println("\nSRTF Scheduling Table:");
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
