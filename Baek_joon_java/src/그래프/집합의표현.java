package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 집합의표현 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[1]);
            int b = Integer.parseInt(ab[2]);

            if (ab[0].equals("0")) {
                union(a, b);
            } else {
                if (checkSum(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean checkSum(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }

    private static int find(int a) {
        if (a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            arr[b] = a;
        }
    }
}
