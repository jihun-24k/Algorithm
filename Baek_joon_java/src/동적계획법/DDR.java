package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DDR {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int[][] strength = {
            {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1}
        };

        int[][][] dp = new int[100_001][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 100_001; k++) {
                    dp[k][i][j] = 100_001 * 4;
                }
            }
        }

        dp[0][0][0] = 0;
        for (int i = 1; i <= input.length - 1; i++) {
            int nextStep = Integer.parseInt(input[i - 1]);

            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (nextStep != l) {
                        dp[i][l][nextStep] = Math.min(dp[i - 1][l][r] + strength[r][nextStep],
                            dp[i][l][nextStep]);
                    }
                    if (nextStep != r) {
                        dp[i][nextStep][r] = Math.min(dp[i - 1][l][r] + strength[l][nextStep],
                            dp[i][nextStep][r]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                min = Math.min(min, dp[input.length - 1][l][r]);
            }
        }
        System.out.println(min);
    }
}
