package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소신장트리 {

    static PriorityQueue<Edge3> edges;
    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edges = new PriorityQueue<>();
        set = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            set[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            edges.add(new Edge3(start, end, value));
        }

        int usedNode = 0;
        int minValue = 0;
        while (usedNode < V - 1) {
            Edge3 e = edges.poll();
            int node1 = e.start;
            int node2 = e.end;
            int value = e.value;

            if (find(node1) != find(node2)) {
                union(node1, node2);
                minValue += value;
                usedNode++;
            }
        }
        System.out.println(minValue);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            set[b] = a;
        }
    }

    private static int find(int n) {
        if (set[n] == n) {
            return n;
        }
        return set[n] = find(set[n]);
    }
}

class Edge3 implements Comparable<Edge3> {

    int start;
    int end;
    int value;

    Edge3(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Edge3 o) {
        return value - o.value;
    }
}