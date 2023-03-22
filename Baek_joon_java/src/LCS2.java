import java.util.ArrayList;
import java.util.Scanner;

public class LCS2 {

    static long[][] dp;
    static ArrayList<Character> answer = new ArrayList<>();
    static char[] str1, str2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str1 = sc.next().toCharArray();
        str2 = sc.next().toCharArray();

        dp = new long[str1.length + 1][str2.length + 1];

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        getStr(str1.length, str2.length);
        System.out.println(answer.size());
        for (int i = answer.size() - 1; i >= 0; i--) {
            System.out.print(answer.get(i));
        }
    }

    public static void getStr(int r, int c) {
        if (r == 0 || c == 0) {
            return;
        }
        if (str1[r - 1] == str2[c - 1]) {
            answer.add(str1[r - 1]);
            getStr(r - 1, c - 1);
        } else {
            if (dp[r - 1][c] > dp[r][c - 1]) {
                getStr(r - 1, c);
            } else {
                getStr(r, c - 1);
            }
        }

    }
}
