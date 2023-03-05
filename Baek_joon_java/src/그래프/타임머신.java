package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 타임머신 {

    static ArrayList<Edge2> arr;
    static long[] distance;
    static int N, M;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        distance = new long[N + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            arr.add(new Edge2(A, B, C));
        }

        bellmanFord();
        if (!checkCycle()) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }

    }

    private static void bellmanFord() {
        distance[1] = 0;
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge2 e = arr.get(j);
                if (distance[e.start] == INF) {
                    continue;
                }
                if (distance[e.end] > distance[e.start] + e.value) {
                    distance[e.end] = distance[e.start] + e.value;
                }
            }
        }
    }

    private static boolean checkCycle() {
        for (int i = 0; i < M; i++) {
            Edge2 e = arr.get(i);
            if (distance[e.start] == INF) {
                continue;
            }
            if (distance[e.end] > distance[e.start] + e.value) {
                return true;
            }
        }
        return false;
    }
}

class Edge2 {

    int start;
    int end;
    int value;

    Edge2(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}