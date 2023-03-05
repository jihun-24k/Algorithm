package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리도시 {

    static ArrayList<Integer>[] cities;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        cities = new ArrayList[N + 1];
        distance = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            cities[i] = new ArrayList<>();
            distance[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            cities[start].add(end);
        }

        bfs(X);

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                answer.add(i);
            }
        }

        Collections.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        distance[v]++;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : cities[now]) {
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
