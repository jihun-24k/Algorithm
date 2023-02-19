package 탐색;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 트리지름구하기 {

    static ArrayList<Edge>[] tree;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1) {
                    break;
                }
                int V = sc.nextInt();
                tree[S].add(new Edge(E, V));
            }
        }

        bfs(1);
        int max = 1;

        for (int i = 2; i <= N; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(max);

        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;

            for (Edge edge : tree[now]) {
                int e = edge.e;
                int value = edge.value;
                if (!visited[e]) {
                    queue.offer(e);
                    distance[e] = distance[now] + value;
                }
            }
        }
    }

    public static class Edge {

        int e;
        int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}
