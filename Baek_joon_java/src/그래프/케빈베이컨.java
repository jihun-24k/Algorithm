package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 케빈베이컨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] kevinBacon = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    kevinBacon[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            kevinBacon[start][end] = 1;
            kevinBacon[end][start] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    kevinBacon[s][e] = Math.min(kevinBacon[s][e],
                        kevinBacon[s][i] + kevinBacon[i][e]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                tmp += kevinBacon[i][j];
            }
            if (min > tmp) {
                min = tmp;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
