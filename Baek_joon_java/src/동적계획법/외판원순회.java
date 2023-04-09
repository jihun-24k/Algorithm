package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회 {

    static final int INF = 1_000_000 * 16 + 1;
    static int N;
    static int[][] W;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine().trim());
        W = new int[16][16];
        dp = new int[16][1 << 16];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));
    }

    private static int tsp(int c, int v) {
        if (v == (1 << N) - 1) {
            return W[c][0] == 0 ? INF : W[c][0];
        }
        if (dp[c][v] != INF) {
            return dp[c][v];
        }
        int min = INF;
        for (int i = 0; i < N; i++) {
            if ((v & (1 << i)) == 0 && W[c][i] != 0) {
                min = Math.min(min, tsp(i, (v | (1 << i))) + W[c][i]);
            }
        }
        return dp[c][v] = min;
    }
}
