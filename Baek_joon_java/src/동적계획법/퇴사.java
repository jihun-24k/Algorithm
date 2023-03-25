package 동적계획법;

import java.util.Scanner;

public class 퇴사 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] times = new int[N + 2][2];
        for (int i = 1; i <= N; i++) {
            int time = sc.nextInt();
            int value = sc.nextInt();
            times[i][0] = time;
            times[i][1] = value;
        }

        int[] dp = new int[N + 2];
        for (int i = N; i > 0; i--) {
            int time = times[i][0];
            int value = times[i][1];

            if (i + time - 1 <= N) {
                dp[i] = Math.max(dp[i + 1], dp[i + time] + value);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}
