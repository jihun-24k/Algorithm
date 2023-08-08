package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

public class 최소비용2 {

    static ArrayList<Edge>[] arr;
    static int[] cost;
    static int[] route;
    static boolean[] visited;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        arr = new ArrayList[n + 1];
        cost = new int[n + 1];
        route = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            String[] info = bf.readLine().split(" ");

            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            int cost = Integer.parseInt(info[2]);

            arr[start].add(new Edge(end, cost));
        }

        String[] info = bf.readLine().split(" ");
        int from = Integer.parseInt(info[0]);
        int to = Integer.parseInt(info[1]);

        bfs(from);

        System.out.println(cost[to]);

        Deque<Integer> deque = new ArrayDeque<>();
        int current = to;

        while (current != 0) {
            deque.addFirst(current);
            current = route[current];
        }

        System.out.println(deque.size());
        for (int i : deque) {
            System.out.print(i + " ");
        }
    }

    public static void bfs(int start) {

        cost[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int now = e.node;

            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            for (Edge ne : arr[now]) {
                int next = ne.node;
                int value = ne.cost;

                if (cost[next] > cost[now] + value) {
                    cost[next] = cost[now] + value;
                    queue.add(new Edge(next, cost[next]));
                    route[next] = now;
                }
            }
        }
    }

    public static class Edge implements Comparable<Edge> {

        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
