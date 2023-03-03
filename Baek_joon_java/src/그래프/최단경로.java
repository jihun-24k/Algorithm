package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 최단경로 {

    static ArrayList<Edge>[] arr;
    static int[] distance;
    static boolean[] visited;

    static PriorityQueue<Edge> queue = new PriorityQueue<>();

    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = br.readLine().split(" ");
        int V = Integer.parseInt(VE[0]);
        int E = Integer.parseInt(VE[1]);

        int K = Integer.parseInt(br.readLine());

        arr = new ArrayList[V + 1];
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
            if (i != K) {
                distance[i] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            int w = Integer.parseInt(uvw[2]);

            arr[u].add(new Edge(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void dijkstra(int k) {
        queue.add(new Edge(k, 0));
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            int start = now.next;
            if (visited[start]) {
                continue;
            }
            visited[start] = true;

            for (Edge e : arr[start]) {
                int next = e.next;
                int nextValue = e.value;

                if (distance[next] > distance[start] + nextValue) {
                    distance[next] = distance[start] + nextValue;
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {

    int next;
    int value;

    Edge(int next, int value) {
        this.next = next;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {
        return this.value - e.value;
    }
}
