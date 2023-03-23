package 동적계획법;

import java.util.Scanner;

public class 행렬곱셈순서 {

    static int[][] dp;
    static Matrix[] M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        M = new Matrix[N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 1; i <= N; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            M[i] = new Matrix(y, x);
        }
        System.out.println(excute(1, N));
    }

    private static int excute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (dp[s][e] != -1) {
            return dp[s][e];
        }
        if (s == e) {
            return 0;
        }
        if (s + 1 == e) {
            return M[s].y * M[s].x * M[e].x;
        }
        for (int i = s; i < e; i++) {
            result = Math.min(result, M[s].y * M[i].x * M[e].x + excute(s, i) + excute(i + 1, e));
        }
        return dp[s][e] = result;
    }
}

class Matrix {

    int y;
    int x;

    Matrix(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
