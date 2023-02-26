package 정수론;

import java.util.Scanner;

public class 최소공배수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int output = 0;
            if (A > B) {
                output = gcd(A, B);
            } else {
                output = gcd(B, A);
            }
            System.out.println(A * B / output);
        }
    }

    private static int gcd(int a, int b) {
        int result = a % b;
        if (result == 0) {
            return b;
        }
        return gcd(b, result);
    }
}
