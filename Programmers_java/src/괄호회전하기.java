import java.util.Stack;

public class 괄호회전하기 {

    static char[] arr;
    static int len;

    public int solution(String s) {
        int answer = 0;

        arr = s.toCharArray();
        len = s.length();

        for (int i = 0; i < len; i++) {
            if (isBracketStr(i)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isBracketStr(int idx) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = arr[(idx + i) % len];

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char top = stack.peek();
                if (isBracket(top, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isBracket(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        return false;
    }
}
