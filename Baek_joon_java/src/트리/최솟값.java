package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최솟값 {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int len = N;
        while (len != 0) {
            len /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeIndex = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        Arrays.fill(tree, Integer.MAX_VALUE);
        for (int i = leftNodeIndex + 1; i <= leftNodeIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            start += leftNodeIndex;
            end += leftNodeIndex;
            System.out.println(getMin(start, end));
        }
        br.close();
    }

    private static long getMin(int start, int end) {
        long minValue = Integer.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                minValue = Math.min(tree[start], minValue);
                start++;
            }
            if (end % 2 == 0) {
                minValue = Math.min(minValue, tree[end]);
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return minValue;
    }

    private static void setTree(int i) {
        while (i != 1) {
            if (tree[i / 2] > tree[i]) {
                tree[i / 2] = tree[i];
            }
            i--;
        }
    }
}
