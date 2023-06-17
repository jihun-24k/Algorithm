package level3;

public class p와y개수 {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        char[] str = s.toCharArray();

        for (int i = 0; i < s.length(); i++){
            if (str[i] == 'p' || str[i] == 'P') p++;
            if (str[i] == 'y' || str[i] == 'Y') y++;
        }

        return (p == y);
    }
}
