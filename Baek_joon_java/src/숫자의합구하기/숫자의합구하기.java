package 숫자의합구하기;

import java.util.Scanner;

public class 숫자의합구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String numbersInput = sc.next();
        char[] numbers = numbersInput.toCharArray();

        int result = 0;

        for (int i = 0; i < N; i++) {
            result += numbers[i] - '0';
        }
        System.out.println(result);
    }
}