import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] queue = new int[20];
        int n, head, i, j, k, seek = 0, max, diff, temp, temp1 = 0, temp2 = 0;
        float avg;
        System.out.println("Enter the max range of disk");
        max = input.nextInt();
        System.out.println("Enter the initial head position");
        head = input.nextInt();
        System.out.println("Enter the size of queue request");
        n = input.nextInt();
        int[] queue1 = new int[20];
        int[] queue2 = new int[20];
        System.out.println("Enter the queue of disk positions to be read");
        for (i = 1; i <= n; i++) {
            temp = input.nextInt();
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
                if (queue2[i] > queue2[j]) {
                    temp = queue2[i];
                    queue2[i] = queue2[j];
                    queue2[j] = temp;
                }
            }
        }
        for (i = 1, j = 0; j < temp1; i++, j++)
            queue[i] = queue1[j];
        queue[i] = max;
        queue[i + 1] = 0;
        for (i = temp1 + 3, j = 0; j < temp2; i++, j++)
            queue[i] = queue2[j];
        queue[0] = head;
        for (j = 0; j <= n + 1; j++) {
            diff = Math.abs(queue[j + 1] - queue[j]);
            seek += diff;
            System.out.println("Disk head moves from " + queue[j] + " to " + queue[j + 1] + " with seek " + diff);
        }
        System.out.println("Total seek time is " + seek);
    }
}
