package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 오민식 {

    static Edge2[] edges;
    static long[] costs;
    static long[] earns;

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge2[M];
        costs = new long[N];
        earns = new long[N];

        Arrays.fill(costs, Long.MIN_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge2(start, end, cost);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            earns[i] = Long.parseLong(st.nextToken());
        }

        bellmanFord(S);
        if (costs[E] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else if (costs[E] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else {
            System.out.println(costs[E]);
        }
    }

    private static void bellmanFord(int start) {
        costs[start] = earns[start];
        for (int i = 0; i < N + 100; i++) {
            for (int j = 0; j < M; j++) {
                Edge2 e = edges[j];
                if (costs[e.start] == Long.MIN_VALUE) {
                    continue;
                }
                if (costs[e.start] == Long.MAX_VALUE) {
                    costs[e.end] = Long.MAX_VALUE;
                }
                if (costs[e.end] < costs[e.start] - e.value + earns[e.end]) {
                    costs[e.end] = costs[e.start] - e.value + earns[e.end];
                    if (N - 1 <= i) {
                        costs[e.end] = Long.MAX_VALUE;
                    }
                }
            }
        }
    }
}
