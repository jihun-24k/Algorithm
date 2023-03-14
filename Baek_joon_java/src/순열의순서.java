import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열의순서 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[21];
        int[] permu = new int[21];
        long[] factor = new long[21];

        factor[0] = 1;
        for (int i = 1; i < 21; i++) {
            factor[i] = factor[i - 1] * i;
        }

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        if (P == 1) {
            long k = Long.parseLong(st.nextToken());
            for (int i = 1; i <= N; i++) {
                int cnt = 1;
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    if (k <= cnt * factor[N - i]) {
                        k -= ((cnt - 1) * factor[N - i]);
                        visited[j] = true;
                        permu[i] = j;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= N; i++) {
                System.out.print(permu[i] + " ");
            }
        } else {
            long k = 1;
            for (int i = 1; i <= N; i++) {
                permu[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < permu[i]; j++) {
                    if (!visited[j]) {
                        cnt++;
                    }
                }
                k += cnt * factor[N - i];
                visited[permu[i]] = true;
            }
            System.out.println(k);
        }
    }
}
