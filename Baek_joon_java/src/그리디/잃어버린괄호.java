package 그리디;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 잃어버린괄호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] expressions = sc.nextLine().split("-");

        Queue<Integer> queue = new LinkedList<>();

        for (String expression : expressions) {
            int tmp = 0;
            for (String num : expression.split("\\+")) {
                tmp += Integer.parseInt(num);
            }
            queue.add(tmp);
        }

        int result = queue.remove();
        while (!queue.isEmpty()) {
            result -= queue.remove();
        }
        System.out.println(result);
    }
}
