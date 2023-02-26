package 정수론;

import java.util.Scanner;

public class 소수구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] primes = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            primes[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (primes[i] != 0) {
                for (int j = i + i; j <= N; j += i) {
                    primes[j] = 0;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (primes[i] != 0) {
                System.out.println(primes[i]);
            }
        }
    }

}
