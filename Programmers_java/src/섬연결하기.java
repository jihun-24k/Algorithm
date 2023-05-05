import java.util.PriorityQueue;

public class 섬연결하기 {

    static PriorityQueue<Edge> queue;
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        queue = new PriorityQueue<>();
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : costs) {
            int node1 = edge[0];
            int node2 = edge[1];
            int cost = edge[2];

            queue.add(new Edge(node1, node2, cost));
        }

        int useEdge = 0;

        while (useEdge < n - 1) {
            Edge e = queue.poll();
            if (find(e.node1) != find(e.node2)) {
                union(e.node1, e.node2);
                answer += e.cost;
                useEdge++;
            }
        }

        return answer;
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private int find(int a) {
        if (a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }
}

class Edge implements Comparable<Edge> {
    int node1;
    int node2;
    int cost;

    public Edge(int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }

    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}
