public class 이진변환반복 {

    public static void main(String[] args) {
        solution("0111010");
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int c = 0;
        int toBinary = 0;

        while (!s.equals("1")) {
            int sLen = s.length();

            c = removeZero(s);
            answer[1] += sLen - c;

            s = Integer.toBinaryString(c);
            toBinary++;
        }
        answer[0] = toBinary;

        return answer;
    }

    private static int removeZero(String s) {
        int c = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1')
                c++;
        }
        return c;
    }
}
