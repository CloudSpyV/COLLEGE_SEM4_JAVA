import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int queue[] = new int[20], n, head, i, j, k, seek = 0, max, diff, temp, queue1[] = new int[20];
        int queue2[] = new int[20], temp1 = 0, temp2 = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the max range of disk");
        max = scanner.nextInt();
        System.out.println("Enter the initial head position");
        head = scanner.nextInt();
        System.out.println("Enter the size of queue request");
        n = scanner.nextInt();
        System.out.println("Enter the queue of disk positions to be read");
        for (i = 1; i <= n; i++) {
            temp = scanner.nextInt();
            if (temp >= head) {
                queue1[temp1] = temp;
                temp1++;
            } else {
                queue2[temp2] = temp;
                temp2++;
            }
        }
        for (i = 0; i < temp1 - 1; i++) {
            for (j = i + 1; j < temp1; j++) {
                if (queue1[i] > queue1[j]) {
                    temp = queue1[i];
                    queue1[i] = queue1[j];
                    queue1[j] = temp;
                }
            }
        }
        for (i = 0; i < temp2 - 1; i++) {
            for (j = i + 1; j < temp2; j++) {
                if (queue2[i] < queue2[j]) {
                    temp = queue2[i];
                    queue2[i] = queue2[j];
                    queue2[j] = temp;
                }
            }
        }
        for (i = 1, j = 0; j < temp1; i++, j++) {
            queue[i] = queue1[j];
            queue[i] = max;
        }
        for (i = temp1 + 2, j = 0; j < temp2; i++, j++)
            queue[i] = queue2[j];
        queue[i] = 0;
        queue[0] = head;
        for (j = 0; j <= n; j++) {
            diff = Math.abs(queue[j + 1] - queue[j]);
            seek += diff;
            System.out.printf("Disk head moves from %d to %d with seek %d\n", queue[j], queue[j + 1], diff);
        }
        System.out.println("Total seek time is " + seek);
    }
}
