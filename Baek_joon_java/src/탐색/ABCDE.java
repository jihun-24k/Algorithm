package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean isend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);

            if (isend) {
                break;
            }
        }
        System.out.println(isend ? 1 : 0);
    }

    private static void dfs(int friend, int depth) {
        if (depth == 5 || isend) {
            isend = true;
            return;
        }

        visited[friend] = true;
        for (int f : arr[friend]) {
            if (!visited[f]) {
                dfs(f, depth + 1);
            }
        }
        visited[friend] = false;
    }
}
