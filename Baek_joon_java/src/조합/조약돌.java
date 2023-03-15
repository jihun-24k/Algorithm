package 조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조약돌 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] stones = new int[51];
        int total = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int stone = Integer.parseInt(st.nextToken());
            stones[i] = stone;
            total += stone;
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        double result = 0.0;
        for (int i = 0; i < M; i++) {
            if (stones[i] >= K) {
                double per = 1.0;
                for (int k = 0; k < K; k++) {
                    per *= (double) (stones[i] - k) / (total - k);
                }
                result += per;
            }
        }
        System.out.println(result);
    }
}
