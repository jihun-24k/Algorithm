public class 피보나치수 {
    public int solution(int n) {

        int[] dp = new int[n + 1];
        int MOD = 1234567;

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % MOD;
        }

        return dp[n];
    }
}
