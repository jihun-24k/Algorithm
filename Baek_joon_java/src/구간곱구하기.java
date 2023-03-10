import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구간곱구하기 {

    static long[] tree;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int len = N;
        while (len != 0) {
            len /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeIndex = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        Arrays.fill(tree, 1);
        for (int i = leftNodeIndex + 1; i <= leftNodeIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(leftNodeIndex + b, c);
            } else if (a == 2) {
                b += leftNodeIndex;
                c += leftNodeIndex;
                System.out.println(getMul(b, (int) c));
            } else {
                return;
            }
        }
        br.close();
    }

    private static long getMul(int s, int e) {
        long result = 1;
        while (s <= e) {
            if (s % 2 == 1) {
                result = result * tree[s] % MOD;
                s++;
            }
            if (e % 2 == 0) {
                result = result * tree[e] % MOD;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return result;
    }

    private static void update(int idx, long value) {
        tree[idx] = value;
        while (idx > 1) {
            idx /= 2;
            tree[idx] = tree[idx * 2] % MOD * tree[idx * 2 + 1] % MOD;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] = tree[i / 2] * tree[i] % MOD;
            i--;
        }
    }
}
