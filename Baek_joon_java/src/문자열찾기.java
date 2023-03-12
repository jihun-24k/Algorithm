import java.util.Scanner;

public class 문자열찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Node root = new Node();
        while (N > 0) {
            Node now = root;
            String text = sc.next();
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                if (now.next[ch - 'a'] == null) {
                    now.next[ch - 'a'] = new Node();
                }

                now = now.next[ch - 'a'];
                if (i == text.length() - 1) {
                    now.isEnd = true;
                }
            }
            N--;
        }

        int result = 0;
        while (M > 0) {
            Node now = root;
            String text = sc.next();
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                if (now.next[ch - 'a'] == null) {
                    break;
                }

                now = now.next[ch - 'a'];
                if (i == text.length() - 1 && now.isEnd) {
                    result++;
                }
            }

            M--;
        }
        System.out.println(result);
    }
}

class Node {

    Node[] next = new Node[26];
    boolean isEnd;
}
