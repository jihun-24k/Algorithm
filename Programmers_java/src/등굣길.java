public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1_000_000_007;

        int[][] dp = new int[101][101];
        dp[1][1] = 1;

        if (puddles[0].length > 0) {
            for (int[] puddle : puddles) {
                int x = puddle[0];
                int y = puddle[1];

                dp[x][y] = -1;
            }
        }

        for (int i = 2; i <= m; i++) {
            if (dp[i-1][1] == -1 || dp[i][1] == -1)
                dp[i][1] = -1;
            else {
                dp[i][1] = 1;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (dp[1][i-1] == -1 || dp[1][i] == -1)
                dp[1][i] = -1;
            else {
                dp[1][i] = 1;
            }
        }


        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (dp[i][j] != -1){
                    if (dp[i - 1][j] == -1 && dp[i][j-1] == -1)
                        dp[i][j] = -1;

                    else if (dp[i - 1][j] == -1)
                        dp[i][j] = dp[i][j-1];

                    else if (dp[i][j-1] == -1)
                        dp[i][j] = dp[i-1][j];

                    else {
                        dp[i][j] = (dp[i - 1][j] + dp[i][j-1]) % mod;
                    }
                }
            }
        }

        return dp[m][n] == -1 ? 0 : dp[m][n];
    }
}
