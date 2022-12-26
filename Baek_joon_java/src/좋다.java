import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좋다 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] A = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int good = 0;
        for (int i = 0; i < N; i++) {
            good += findGood(A, i);
        }
        System.out.println(good);
    }

    public static int findGood(int[] A, int idx) {
        int num = A[idx];
        for (int i = 0; i < A.length; i++) {
            if (i == idx) {
                continue;
            }
            for (int j = i + 1; j < A.length; j++) {
                if (j == idx) {
                    continue;
                }
                if (A[i] + A[j] == num) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
