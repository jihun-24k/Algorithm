package 그리디;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 수묶기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        int num = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            num = sc.nextInt();
            if (num > 0) {
                if (num == 1) {
                    result++;
                    continue;
                }
                plus.add(num);
            } else {
                minus.add(num);
            }
        }

        int num1 = 0;
        int num2 = 0;
        while (!minus.isEmpty()) {
            if (minus.size() == 1) {
                result += minus.remove();
                break;
            }
            num1 = minus.remove();
            num2 = minus.remove();
            result += num1 * num2;
        }

        while (!plus.isEmpty()) {
            if (plus.size() == 1) {
                result += plus.remove();
                break;
            }
            num1 = plus.remove();
            num2 = plus.remove();
            result += num1 * num2;
        }
        System.out.println(result);
    }

}
