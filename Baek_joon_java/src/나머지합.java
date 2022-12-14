import java.io.IOException;
import java.util.Scanner;

public class 나머지합 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] A = new long[N];
        long[] counts = new long[M];
        long result = 0;
        A[0] = sc.nextInt();

        for (int i = 1; i < N; i++) {
            A[i] = A[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int remainder = (int) A[i] % M;
            if (remainder == 0) {
                result++;
            }
            counts[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (counts[i] > 1) {
                result += (counts[i] * (counts[i] - 1) / 2);
            }
        }
        System.out.println(result);
    }
}
