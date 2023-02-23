package 정수론;

import java.util.Scanner;

public class 제곱이아닌수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] sqrt = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIdx = min / pow;
            if (min % pow != 0) {
                startIdx++;
            }
            for (long j = startIdx; pow * j <= max; j++) {
                sqrt[(int) ((pow * j) - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!sqrt[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
