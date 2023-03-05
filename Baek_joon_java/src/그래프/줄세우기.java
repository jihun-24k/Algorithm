package 그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 줄세우기 {

    static ArrayList<Integer>[] arr;

    static int[] degree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new ArrayList[N + 1];
        degree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            arr[A].add(B);
            degree[B]++;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int student = queue.poll();
            System.out.print(student + " ");

            for (int n : arr[student]) {
                degree[n]--;
                if (degree[n] == 0) {
                    queue.add(n);
                }
            }
        }
    }
}
