package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 플로이드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1000001;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            String[] info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            int cost = Integer.parseInt(info[2]);
            arr[start][end] = Math.min(arr[start][end], cost);
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    arr[s][e] = Math.min(arr[s][e], arr[s][i] + arr[i][e]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1000001) {
                    System.out.print("0 ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
