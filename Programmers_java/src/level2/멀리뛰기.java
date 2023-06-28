package level2;

public class 멀리뛰기 {

    static int MOD = 1234567;

    public long solution(int n) {
        if (n == 1) {
            return 1;
        }

        long dp[] = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }
}
