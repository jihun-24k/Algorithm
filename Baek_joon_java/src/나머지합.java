import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            A[i] = A[i - 1] + number;
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                if ((A[j] - A[i-1]) % M == 0) result += 1;
            }
        }
        System.out.println(result);
    }
}
