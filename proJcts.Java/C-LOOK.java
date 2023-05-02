import java.util.Scanner;

public class DiskScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, i, j, head, seektime = 0;
        int[] item = new int[20];
        int[] dst = new int[20];
        System.out.println("Enter no. of locations:");
        n = scanner.nextInt();
        System.out.println("Enter position of head:");
        head = scanner.nextInt();
        System.out.println("Enter elements of disk queue:");
        for (i = 0; i < n; i++) {
            item[i] = scanner.nextInt();
            dst[i] = head - item[i];
        }
        // Selection Sort
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                if (dst[j] > dst[i]) {
                    int temp = dst[j];
                    dst[j] = dst[i];
                    dst[i] = temp;
                    temp = item[i];
                    item[i] = item[j];
                    item[j] = temp;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (item[i] >= head) {
                j = i;
                break;
            }
        }
        System.out.println("j=" + j);
        System.out.println("\nOrder of disk allocation is as follows:");
        for (i = j; i < n; i++) {
            System.out.print(" -> " + item[i]);
            seektime += Math.abs(head - item[i]);
            head = item[i];
        }
        for (i = 0; i < j; i++) {
            System.out.print(" -> " + item[i]);
            seektime += Math.abs(head - item[i]);
            head = item[i];
        }
        System.out.println("\n\nSeek Time: " + seektime + "\n\n");
    }
}
