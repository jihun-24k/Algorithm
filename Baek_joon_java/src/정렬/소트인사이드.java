package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 소트인사이드 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] number = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            number[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        Arrays.sort(number);

        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(number[i]);
        }
    }

}
