package 정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] buildings = new int[n];
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(buildings[0], 1));

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek().height <= buildings[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek().index;
            }

            stack.add(new Node(buildings[i], i + 1));
        }

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }

    public static class Node {

        int height;
        int index;

        public Node(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
