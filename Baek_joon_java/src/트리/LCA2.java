package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LCA2 {

    static ArrayList<Integer>[] tree;

    static boolean[] visited;
    static int[] depth;
    static int[][] parent;

    static int kMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        depth = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        int tmp = 1;
        kMax = 0;
        while (tmp <= N) {
            tmp <<= 1;
            kMax++;
        }

        parent = new int[kMax + 1][N + 1];
        bfs(1);
        for (int k = 1; k <= kMax; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            System.out.println(lca(node1, node2));
        }
    }

    private static int lca(int n1, int n2) {
        if (depth[n1] > depth[n2]) {
            n1 = n1 ^ n2;
            n2 = n1 ^ n2;
            n1 = n1 ^ n2;
        }

        for (int k = kMax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[n2] - depth[n1]) {
                if (depth[n1] <= depth[parent[k][n2]]) {
                    n2 = parent[k][n2];
                }
            }
        }

        for (int k = kMax; k >= 0; k--) {
            if (parent[k][n1] != parent[k][n2]) {
                n1 = parent[k][n1];
                n2 = parent[k][n2];
            }
        }

        if (n1 != n2) {
            n1 = parent[0][n1];
        }
        return n1;
    }

    private static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            for (int next : tree[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    parent[0][next] = now;
                    depth[next] = depth[now] + 1;
                }
            }
        }
    }

}
