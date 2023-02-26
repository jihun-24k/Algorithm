package 탐색;

import java.util.Scanner;

public class K번째수 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        long start = 1;
        long end = k;
        long ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (long i = 1; i <= N; i++) {
                cnt += Math.min(N, mid / i);
            }
            if (cnt < k) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
