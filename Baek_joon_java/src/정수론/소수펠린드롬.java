package 정수론;

import java.util.Scanner;

public class 소수펠린드롬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] primes = new int[10000001];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = i;
        }

        for (int i = 2; i < Math.sqrt(primes.length); i++) {
            if (primes[i] != 0) {
                for (int j = i + i; j < primes.length; j += i) {
                    primes[j] = 0;
                }
            }
        }

        for (int i = N; i < primes.length; i++) {
            if (primes[i] != 0 && isPalindrome(primes[i])) {
                System.out.println(primes[i]);
                break;
            }
        }
    }

    private static boolean isPalindrome(int prime) {
        String ori = String.valueOf(prime);
        StringBuffer sb = new StringBuffer(ori);
        String reverse = sb.reverse().toString();
        return ori.equals(reverse);
    }
}
