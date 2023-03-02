package 그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 게임개발 {

    static ArrayList<Integer>[] arr;
    static int[] degree;
    static int[] times;
    static int[] plusTimes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new ArrayList[N + 1];
        degree = new int[N + 1];
        times = new int[N + 1];
        plusTimes = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int time = sc.nextInt();
            times[i] = time;
            while (true) {
                int struct = sc.nextInt();
                if (struct == -1) {
                    break;
                }
                arr[struct].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int struct = queue.poll();

            for (int n : arr[struct]) {
                degree[n]--;
                plusTimes[n] = Math.max(plusTimes[n], plusTimes[struct] + times[struct]);
                if (degree[n] == 0) {
                    queue.add(n);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(times[i] + plusTimes[i]);
        }
    }
}
