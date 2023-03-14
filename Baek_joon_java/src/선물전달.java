import java.util.Scanner;

public class 선물전달 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] dp = new long[1000001];

        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = (i - 1) * (dp[i - 2] + dp[i - 1]) % 1000000000;
        }

        System.out.println(dp[N]);
    }
}
