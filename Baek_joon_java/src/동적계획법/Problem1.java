package 동적계획법;

public class Problem1 {

    public static void main(String[] args) {
        System.out.print(solution("acbcbbc"));
    }

    public static int solution(String S) {
        int result = 0;
        int[] counts = new int[26];
        for (char ch : S.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (int count : counts) {
            if (count % 2 == 1) {
                result++;
            }
        }
        return result;
    }
}
