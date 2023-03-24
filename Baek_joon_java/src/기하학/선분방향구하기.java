package 기하학;

import java.util.Scanner;

public class 선분방향구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        int result = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if (result < 0) {
            System.out.println(-1);
        } else if (result == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
