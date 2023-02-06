package 자료구조;

import java.util.Arrays;
import java.util.Scanner;

public class ATM시간 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] queue = new int[N];

        for (int i = 0; i < N; i++) {
            queue[i] = sc.nextInt();
        }

        Arrays.sort(queue);
        int result = 0;
        int before = 0;
        for (int waiting : queue) {
            result += before + waiting;
            before += waiting;
        }

        System.out.println(result);
    }
}
