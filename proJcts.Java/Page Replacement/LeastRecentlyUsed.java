import java.util.Scanner;

public class LeastRecentlyUsed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nopages, nofaults, count = 0;
        int[] page, frame, fcount;

        System.out.print("\n\tEnter no of pages for which you want to calculate page faults:>");
        nopages = scanner.nextInt();

        page = new int[nopages];
        System.out.print("\n\tEnter the Reference String:");
        for (int i = 0; i < nopages; i++) {
            page[i] = scanner.nextInt();
        }

        System.out.print("\n\tEnter the Number of frames:");
        nofaults = scanner.nextInt();

        frame = new int[nofaults];
        fcount = new int[nofaults];
        for (int i = 0; i < nofaults; i++) {
            frame[i] = -1;
            fcount[i] = 0;
        }

        int i = 0;
        while (i < nopages) {
            int j = 0, flag = 0;

            while (j < nofaults) {
                if (page[i] == frame[j]) {
                    flag = 1;
                    fcount[j] = i + 1;
                }
                j++;
            }

            j = 0;
            System.out.print("\n\t***\n");
            System.out.print("\t" + page[i] + "-->");

            if (flag == 0) {
                int min = 0, k = 0;

                while (k < nofaults - 1) {
                    if (fcount[min] > fcount[k + 1]) {
                        min = k + 1;
                    }
                    k++;
                }

                frame[min] = page[i];
                fcount[min] = i + 1;
                count++;

                while (j < nofaults) {
                    System.out.print("\t" + frame[j] + "");
                    j++;
                }
            }

            i++;
        }

        System.out.print("\n\t***\n");
        System.out.print("\n\tPage Fault:" + count);

        scanner.close();
    }
}
