import java.util.Scanner;

public class ShortestJobFirst {
    Scanner sc = new Scanner(System.in);
    int n;
    int[] burstTime;
    int[] waitingTime;
    int[] turnaroundTime;

    public void input() {
        System.out.print("Enter number of processes: ");
        n = sc.nextInt();
        burstTime = new int[n];
        waitingTime = new int[n];
        turnaroundTime = new int[n];
        System.out.println("Enter burst time for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
        }
    }

    public void sort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (burstTime[i] > burstTime[j]) {
                    int temp = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = temp;
                }
            }
        }
    }

    public void calculate() {
        waitingTime[0] = 0;
        turnaroundTime[0] = burstTime[0];
        for (int i = 1; i < n; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
            turnaroundTime[i] = waitingTime[i] + burstTime[i];
        }
    }

    public void print() {
        System.out.println("\nSJF Scheduling Table:");
        System.out.println("-------------------------------------------------");
        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.println(
                    "P" + (i + 1) + "\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
        System.out.println("-------------------------------------------------");
    }

    public void average() {
        float totalWaitingTime = 0;
        float totalTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }
        System.out.println("Average Waiting Time: " + (totalWaitingTime / n));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / n));
    }

    public static void main(String[] args) {
        ShortestJobFirst sjf = new ShortestJobFirst();
        sjf.input();
        sjf.sort();
        sjf.calculate();
        sjf.print();
        sjf.average();
    }
}
