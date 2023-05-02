import java.util.Scanner;

public class PrioritySchedulingPreemptive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input the number of processes
        System.out.print("Enter the number of processes: ");
        int numProcesses = input.nextInt();

        // Declare arrays to store process data
        int[] burstTime = new int[numProcesses];
        int[] arrivalTime = new int[numProcesses];
        int[] priority = new int[numProcesses];
        int[] remainingTime = new int[numProcesses];
        boolean[] isCompleted = new boolean[numProcesses];

        // Input the process data
        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Process " + (i + 1) + ":");
            System.out.print("  Arrival time: ");
            arrivalTime[i] = input.nextInt();
            System.out.print("  Burst time: ");
            burstTime[i] = input.nextInt();
            System.out.print("  Priority: ");
            priority[i] = input.nextInt();

            // Initialize remaining time and completion status
            remainingTime[i] = burstTime[i];
            isCompleted[i] = false;
        }

        input.close();

        int currentTime = 0; // Current time
        int completedProcesses = 0; // Number of completed processes
        int[] turnaroundTime = new int[numProcesses]; // Array to store turnaround time of each process
        int[] waitingTime = new int[numProcesses]; // Array to store waiting time of each process

        // Loop until all processes are completed
        while (completedProcesses < numProcesses) {
            int highestPriority = Integer.MAX_VALUE;
            int selectedProcess = -1;

            // Find the process with the highest priority that has arrived and not completed
            for (int i = 0; i < numProcesses; i++) {
                if (arrivalTime[i] <= currentTime && !isCompleted[i] && priority[i] < highestPriority) {
                    highestPriority = priority[i];
                    selectedProcess = i;
                }
            }

            // If a process is found, execute it for 1 time unit
            if (selectedProcess != -1) {
                remainingTime[selectedProcess]--;

                // If the process has completed execution, update completion time and completion
                // status
                if (remainingTime[selectedProcess] == 0) {
                    completedProcesses++;
                    int completionTime = currentTime + 1;
                    turnaroundTime[selectedProcess] = completionTime - arrivalTime[selectedProcess];
                    waitingTime[selectedProcess] = turnaroundTime[selectedProcess] - burstTime[selectedProcess];
                    isCompleted[selectedProcess] = true;
                }
            }

            currentTime++; // Increment the current time
        }

        // Calculate and display average turnaround time and waiting time
        double avgTurnaroundTime = 0.0;
        double avgWaitingTime = 0.0;
        for (int i = 0; i < numProcesses; i++) {
            avgTurnaroundTime += turnaroundTime[i];
            avgWaitingTime += waitingTime[i];
        }
        avgTurnaroundTime /= numProcesses;
        avgWaitingTime /= numProcesses;
        System.out.printf("Average turnaround time: %.2f\n", avgTurnaroundTime);
        System.out.printf("Average waiting time: %.2f\n", avgWaitingTime);
    }
}
