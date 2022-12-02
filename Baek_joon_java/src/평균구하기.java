import java.util.Scanner;

public class 평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i<N; i++) {
            numbers[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for (int number : numbers) {
            max = Math.max(max, number);
            sum += number;
        }
        System.out.println(sum * 100.0 / max / N);
    }
}