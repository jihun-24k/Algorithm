package 그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹 {

    static ArrayList<Integer>[] computers;
    static boolean[] visited;
    static int N;
    static int maxNum = 0;
    static int[] counters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        computers = new ArrayList[N + 1];
        counters = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int trust = Integer.parseInt(st.nextToken());
            int trusted = Integer.parseInt(st.nextToken());
            computers[trust].add(trusted);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        for (int c : counters)
            maxNum = Math.max(c, maxNum);

        for (int c = 1; c <= N; c++) {
            if (counters[c] == maxNum) {
                bw.write(c + " ");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : computers[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    counters[next]++;
                }
            }
        }
    }
}
