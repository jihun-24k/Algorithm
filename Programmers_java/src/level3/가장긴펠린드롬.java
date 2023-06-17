package level3;

class 가장긴펠린드롬 {
    static int strLen;
    static char[] str;

    public int solution(String s) {
        int answer = 0;

        strLen = s.length();
        str = s.toCharArray();

        if (strLen == 1) {
            return strLen;
        }

        for (int i = 1; i < strLen; i++) {
            answer = Math.max(answer, compare(i-1, i + 1, 1));
            answer = Math.max(answer, compare(i -1 , i, 0));
        }
        return answer;
    }

    private int compare(int a, int b, int max) {
        if (a < 0 || b >= strLen || str[a] != str[b]) {
            return max;
        }

        return compare(a - 1, b + 1, max + 2);
    }
}
