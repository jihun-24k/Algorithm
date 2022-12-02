import java.util.Scanner;

public class 구간합구하기4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N];
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        sum[0] = numbers[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + numbers[i];
        }

        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            result[i] = sum[end] - sum[from-1];
            System.out.println(result[i]);
        }
    }
}
