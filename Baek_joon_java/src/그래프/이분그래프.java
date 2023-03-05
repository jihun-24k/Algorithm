package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 이분그래프 {

    static ArrayList<Integer>[] graph;
    static boolean[] vistied;
    static boolean hasCycle;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            graph = new ArrayList[V + 1];
            vistied = new boolean[V + 1];
            check = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                graph[start].add(end);
                graph[end].add(start);
            }

            hasCycle = false;
            for (int i = 1; i <= V; i++) {
                if (!hasCycle) {
                    dfs(i);
                } else {
                    break;
                }
            }
            if (!hasCycle) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            br.close();
        }
    }

    public static void dfs(int node) {
        vistied[node] = true;
        for (int next : graph[node]) {
            if (!vistied[next]) {
                check[next] = (check[node] + 1) % 2;
                dfs(next);
            } else if (check[next] == check[node]) {
                hasCycle = true;
            }
        }
    }
}
