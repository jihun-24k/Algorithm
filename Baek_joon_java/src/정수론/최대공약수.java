package 정수론;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 최대공약수 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long A = sc.nextLong();
        long B = sc.nextLong();

        for (long p = 0; p < gcd(A, B); p++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
