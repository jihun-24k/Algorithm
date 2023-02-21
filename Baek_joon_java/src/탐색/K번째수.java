package 탐색;

import java.util.Arrays;
import java.util.Scanner;

public class K번째수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] B = new int[k + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if (N * i + j - 1 >= k) {
                    break;
                }
                B[N * i + j - 1] = (i + 1) * j;
            }
        }

        Arrays.sort(B);
        System.out.println(B[k]);
    }
}
