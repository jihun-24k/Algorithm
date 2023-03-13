import java.util.Scanner;

public class 이항계수1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        System.out.println(dp[N][K]);
    }
}
