package level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

    static ArrayList<Integer>[] graph;
    static int[] count;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        graph = new ArrayList[n + 1];
        count = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int [] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        bfs(n);

        for (int i = 1; i <= n; i++) {
            if (!(count[i] == 0)) {
                answer = count[i];
            }
            System.out.println(count[i]);
        }
        return answer;
    }

    private void bfs(int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(new int[]{1, 0});
        visited[1] = true;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int now = node[0];
            int dist = node[1];

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, dist + 1});
                    count[dist + 1]++;
                }
            }
        }
    }
}
