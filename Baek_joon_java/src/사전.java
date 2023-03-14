import java.util.Scanner;

public class 사전 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[202][202];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    if (dp[i][j] > 1000000000) {
                        dp[i][j] = 1000000001;
                    }
                }
            }
        }

        if (dp[N + M][M] >= K) {
            while (!(N == 0 && M == 0)) {
                if (dp[N - 1 + M][M] >= K) {
                    System.out.print("a");
                    N--;
                } else {
                    System.out.print("z");
                    K -= dp[N - 1 + M][M];
                    M--;
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}
