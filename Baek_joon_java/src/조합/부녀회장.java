package 조합;

import java.util.Scanner;

public class 부녀회장 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[][] apt = new int[15][15];
        for (int i = 1; i < 15; i++) {
            apt[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
            }
        }

        for (int t = 0; t < T; t++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(apt[k][n]);
        }
    }
}
