import java.util.*;

public class BankersAlgorithm {
    private int[][] need; // Need matrix
    private int[][] allocation; // Allocation matrix
    private int[] available; // Available resource vector
    private int[] max; // Maximum resource vector
    private int numProcesses; // Number of processes
    private int numResources; // Number of resource types

    public BankersAlgorithm(int[][] allocation, int[] available, int[] max) {
        this.allocation = allocation;
        this.available = available;
        this.max = max;
        this.numProcesses = allocation.length;
        this.numResources = available.length;
        this.need = new int[numProcesses][numResources];
        for (int i = 0; i < numProcesses; i++) {
            for (int j = 0; j < numResources; j++) {
                need[i][j] = max[i] - allocation[i][j];
            }
        }
    }

    public boolean isSafeState() {
        boolean[] finished = new boolean[numProcesses];
        int[] work = Arrays.copyOf(available, numResources);

        while (true) {
            boolean foundProcess = false;
            for (int i = 0; i < numProcesses; i++) {
                if (!finished[i] && hasEnoughResources(need[i], work)) {
                    foundProcess = true;
                    finished[i] = true;
                    for (int j = 0; j < numResources; j++) {
                        work[j] += allocation[i][j];
                    }
                }
            }
            if (!foundProcess) {
                break;
            }
        }

        for (boolean b : finished) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private boolean hasEnoughResources(int[] need, int[] work) {
        for (int i = 0; i < numResources; i++) {
            if (need[i] > work[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int numProcesses = sc.nextInt();
        System.out.print("Enter number of resources: ");
        int numResources = sc.nextInt();

        int[][] allocation = new int[numProcesses][numResources];
        int[] available = new int[numResources];
        int[] max = new int[numProcesses];

        System.out.println("Enter allocation matrix:");
        for (int i = 0; i < numProcesses; i++) {
            for (int j = 0; j < numResources; j++) {
                allocation[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter available vector:");
        for (int i = 0; i < numResources; i++) {
            available[i] = sc.nextInt();
        }

        System.out.println("Enter maximum matrix:");
        for (int i = 0; i < numProcesses; i++) {
            for (int j = 0; j < numResources; j++) {
                max[i] = sc.nextInt();
            }
        }

        BankersAlgorithm ba = new BankersAlgorithm(allocation, available, max);

        if (ba.isSafeState()) {
            System.out.println("Safe state");
        } else {
            System.out.println("Unsafe state");
        }
        sc.close();
    }
}
