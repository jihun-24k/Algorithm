import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰정사각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        long result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result * result);
    }
}
