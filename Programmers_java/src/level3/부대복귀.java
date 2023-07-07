package level3;

import java.util.*;

public class 부대복귀 {
    static ArrayList<Integer>[] graph;
    static int[] dist;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];

            graph[start].add(end);
            graph[end].add(start);
        }

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(destination);

        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]] == Integer.MAX_VALUE ? -1 : dist[sources[i]];
        }

        return answer;
    }

    public void dijkstra(int destination) {
        dist[destination] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(destination, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int node = current.node;
            int cost = current.cost;

            for (int nextNode : graph[node]) {
                int nextCost = cost + 1;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new Edge(nextNode, nextCost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }
}
