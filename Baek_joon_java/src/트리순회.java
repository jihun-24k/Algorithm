import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 트리순회 {

    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int parent = input[0].charAt(0) - 'A';
            char leftChild = input[1].charAt(0);
            char rightChild = input[2].charAt(0);

            if (leftChild != '.') {
                tree[parent][0] = leftChild - 'A';
            } else {
                tree[parent][0] = -1;
            }
            if (rightChild != '.') {
                tree[parent][1] = rightChild - 'A';
            } else {
                tree[parent][1] = -1;
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    static void preOrder(int node) {
        if (node == -1) {
            return;
        }
        System.out.print((char) (node + 'A'));
        preOrder(tree[node][0]);
        preOrder(tree[node][1]);
    }

    static void inOrder(int node) {
        if (node == -1) {
            return;
        }
        inOrder(tree[node][0]);
        System.out.print((char) (node + 'A'));
        inOrder(tree[node][1]);
    }

    static void postOrder(int node) {
        if (node == -1) {
            return;
        }
        postOrder(tree[node][0]);
        postOrder(tree[node][1]);
        System.out.print((char) (node + 'A'));
    }
}
