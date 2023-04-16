import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : str) {
           if (ch == '(') {
               stack.push(ch);
           }
           if (ch == ')') {
               if (stack.isEmpty())
                   return false;
               if (stack.pop() == ')')
                   return false;
           }
        }

        if (stack.isEmpty())
            return true;
        return false;
    }
}
