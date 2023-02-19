package 탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 신기한소수 {

    static int N;
    static List<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        result = new ArrayList<>();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        Collections.sort(result);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static void dfs(int n, int digit) {
        if (digit == N) {
            if (isPrime(n)) {
                result.add(n);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(n * 10 + i)) {
                dfs(n * 10 + i, digit + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
