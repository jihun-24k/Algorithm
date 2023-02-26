package 정수론;

import java.util.Scanner;

public class 거의소수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long[] primes = new long[10000001];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(primes.length); i++) {
            if (primes[i] != 0) {
                for (int j = i + i; j < primes.length; j += i) {
                    primes[j] = 0;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (primes[i] != 0) {
                long temp = primes[i];
                while ((double) primes[i] <= (double) B / (double) temp) {
                    if ((double) primes[i] >= (double) A / (double) temp) {
                        count++;
                    }
                    temp = temp * primes[i];
                }
            }
        }
        System.out.println(count);
    }
}
