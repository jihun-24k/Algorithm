package 그리디;

import java.util.Scanner;

public class 동전개수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coinSet = new int[N];
        int coin = 0;

        for (int i = N - 1; i >= 0; i--) {
            coinSet[i] = sc.nextInt();
        }

        for (int value : coinSet) {
            while (K - value >= 0) {
                K -= value;
                coin++;
            }
        }
        System.out.println(coin);
    }
}
