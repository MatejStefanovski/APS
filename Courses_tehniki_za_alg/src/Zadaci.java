import java.util.*;

public class Zadaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] tasks = new int[N];
        for (int i = 0; i < N; i++) {
            tasks[i] = sc.nextInt();
        }

        Arrays.sort(tasks);
        reverse(tasks);

        int days = 0;
        int totalFreeHours = 0;

        boolean[] done = new boolean[N];

        int finished = 0;

        while (finished < N) {
            days++;

            int[] capacity = new int[M];
            Arrays.fill(capacity, 8);

            for (int i = 0; i < N; i++) {
                if (done[i]) continue;

                for (int j = 0; j < M; j++) {
                    if (capacity[j] >= tasks[i]) {
                        capacity[j] -= tasks[i];
                        done[i] = true;
                        finished++;
                        break;
                    }
                }
            }

            for (int c : capacity) {
                totalFreeHours += c;
            }
        }

        System.out.println(days + " " + totalFreeHours);
    }

    private static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = tmp;
        }
    }
}
