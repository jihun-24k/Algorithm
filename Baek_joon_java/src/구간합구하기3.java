import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기3 {

    static long[] tree;

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
        int leftNodeStartIndex = treeSize / 2 - 1;

        tree = new long[treeSize + 1];

        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(leftNodeStartIndex + b, c);
            }
            if (a == 2) {
                b += leftNodeStartIndex;
                c += leftNodeStartIndex;
                System.out.println(sumInterval(b, (int) c));
            }
        }
        br.close();
    }

    private static void update(int idx, long value) {
        long diff = value - tree[idx];
        while (idx > 0) {
            tree[idx] += diff;
            idx /= 2;
        }
    }

    private static long sumInterval(int start, int end) {
        long sum = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start];
                start++;
            }
            if (end % 2 == 0) {
                sum += tree[end];
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return sum;
    }

    private static void setTree(int idx) {
        while (idx != 1) {
            tree[idx / 2] += tree[idx];
            idx--;
        }
    }
}
