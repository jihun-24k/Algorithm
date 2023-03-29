package 동적계획법;

import java.util.Scanner;

public class 고층빌딩 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        int mod = 1_000_000_007;

        long[][][] dp = new long[N + 1][L + 1][R + 1];
        dp[1][1][1] = 1;
        for (int n = 2; n <= N; n++) {
            for (int l = 1; l <= L; l++) {
                for (int r = 1; r <= R; r++) {
                    dp[n][l][r] =
                        (dp[n - 1][l - 1][r] + dp[n - 1][l][r - 1] + dp[n - 1][l][r] * (n - 2))
                            % mod;
                }
            }
        }

        System.out.println(dp[N][L][R]);
    }
}
