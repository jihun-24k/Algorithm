import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LCA {

    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] depths;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        depths = new int[N + 1];
        parent = new int[N + 1];
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

        bfs(1);
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            System.out.println(lca(node1, node2));
        }
    }

    private static int lca(int n1, int n2) {
        if (depths[n1] < depths[n2]) {
            n1 = n1 ^ n2;
            n2 = n1 ^ n2;
            n1 = n1 ^ n2;
        }

        while (depths[n1] != depths[n2]) {
            n1 = parent[n1];
        }

        while (n1 != n2) {
            n1 = parent[n1];
            n2 = parent[n2];
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
                    parent[next] = now;
                    depths[next] = depths[now] + 1;
                }
            }
        }
    }
}
