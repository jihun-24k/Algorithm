package level3;

import java.util.Stack;

public class 표편집 {
    static int now;
    static boolean[] deleted;

    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();

        Stack<Node> history = new Stack<>();
        deleted = new boolean[n];
        int[] pre = new int[n];
        int[] next = new int[n];
        now = k;

        for (int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        for (String c : cmd) {
            if (c.length() != 1) {
                String[] arr = c.split(" ");
                String e = arr[0];
                int num = Integer.parseInt(arr[1]);

                if (e.equals("U")) {
                    while (num-- > 0) {
                        now = pre[now];
                    }
                }
                else {
                    while (num-- > 0) {
                        now = next[now];
                    }
                }
            }
            else {
                if (c.equals("C")) {
                    deleted[now] = true;
                    history.add(new Node(pre[now], next[now], now));
                    if (pre[now] != -1) {
                        next[pre[now]] = next[now];
                    }
                    if (next[now] != -1) {
                        pre[next[now]] = pre[now];
                    }

                    if(next[now] != -1) now = next[now];
                    else now = pre[now];
                }
                else {
                    Node node = history.pop();
                    if(node.pre != -1) next[node.pre] = node.value;
                    if(node.next != -1) pre[node.next] = node.value;
                    deleted[node.value] = false;
                }
            }
        }

        for (boolean d : deleted) {
            if (d) {
                answer.append("X");
            }
            else {
                answer.append("O");
            }
        }

        return answer.toString();
    }

    public class Node {
        int pre;
        int next;
        int value;

        public Node(int pre, int next, int value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }
}
