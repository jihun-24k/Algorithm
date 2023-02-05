package 자료구조;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 절댓값힙 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> absHeap = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if (firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1;
            }

            return firstAbs - secondAbs;
        });

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                if (absHeap.isEmpty()) {
                    System.out.println(x);
                } else {
                    System.out.println(absHeap.poll());
                }
            } else {
                absHeap.add(x);
            }
        }
    }

}
