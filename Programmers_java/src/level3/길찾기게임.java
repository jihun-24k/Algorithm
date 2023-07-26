package level3;

import java.util.Arrays;

public class 길찾기게임 {

    static Node[] nodes;
    static int[][] answer;
    static int idx;

    public int[][] solution(int[][] nodeinfo) {
        nodes = new Node[nodeinfo.length];

        for (int i = 1; i <= nodeinfo.length; i++) {
            int[] now = nodeinfo[i - 1];
            nodes[i-1] = new Node(i, now[0], now[1]);
        }

        Arrays.sort(nodes);

        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            insertNode(root, nodes[i]);
        }

        answer = new int[2][nodeinfo.length];

        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);

        return answer;
    }

    private void preorder(Node root) {
        if (root !=null) {
            answer[0][idx++] = root.num;
            preorder(root.left);
            preorder(root.right);
        }
    }

    private void postorder(Node root) {
        if (root !=null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.num;
        }
    }

    public void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
}

class Node implements Comparable<Node>{

    int num;
    int x;
    int y;
    Node left = null;
    Node right = null;

    public Node(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        if (o.y == this.y) {
            return this.x - o.x;
        }
        return o.y - this.y;
    }
}
