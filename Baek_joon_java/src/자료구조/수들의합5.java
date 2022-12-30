package 자료구조;

import java.util.Scanner;

public class 수들의합5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int answer = 1;
        int start = N / 2;
        int end = start + 1;
        int sum = start + end;

        while (start > 0) {
            if (sum == N) {
                start--;
                end--;
                sum -= end - start + 1;
                answer++;
            } else if (sum > N) {
                start--;
                end--;
                sum -= end - start + 1;
            } else {
                start--;
                sum += start;
            }
        }
        System.out.println(answer);
    }
}
