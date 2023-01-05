package 자료구조;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int number = 1;
        boolean isNo = false;
        Stack<Integer> stack = new Stack<>();
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int checkNum = sc.nextInt();
            if (number <= checkNum) {
                while (number <= checkNum) {
                    stack.push(number++);
                    operations.add("+");
                }
                stack.pop();
                operations.add("-");
            } else {
                int popNum = stack.pop();
                if (popNum > checkNum) {
                    System.out.println("NO");
                    isNo = true;
                    break;
                } else {
                    operations.add("-");
                }
            }
        }
        if (!isNo) {
            operations.forEach(System.out::println);
        }
    }
}
