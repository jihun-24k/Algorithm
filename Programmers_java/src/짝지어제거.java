import java.util.Stack;

public class 짝지어제거 {

    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        char[] str = s.toCharArray();

        for (char c : str) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
