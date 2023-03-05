package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 최소비용 {

    static ArrayList<Edge>[] arr;
    static int[] cost;
    static boolean[] visited;

    static PriorityQueue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new ArrayList[N + 1];
        cost = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            int w = Integer.parseInt(uvw[2]);

            arr[u].add(new Edge(v, w));
        }

        String[] SE = br.readLine().split(" ");
        int start = Integer.parseInt(SE[0]);
        int end = Integer.parseInt(SE[1]);
        cost[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int now = e.vertex;

            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            for (Edge city : arr[now]) {
                int next = city.vertex;
                int value = city.value;

                if (cost[next] > cost[now] + value) {
                    cost[next] = cost[now] + value;
                    queue.add(new Edge(next, cost[next]));
                }
            }
        }

        System.out.println(cost[end]);
    }
}