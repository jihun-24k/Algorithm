public class 연속펄스부분구하기 {

    public static void main(String[] args) {
        solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4});
    }

    public static long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        int len = sequence.length;

        long[] plus = new long[len];
        long[] minus = new long[len];

        plus[0] = sequence[0];
        minus[0] -= sequence[0];

        if (len == 1) {
            return Math.max(plus[0], minus[0]);
        }

        for (int i = 1; i < len; i++) {
            int p = (i % 2 == 1 ? -1 : 1) * sequence[i];
            int m = (i % 2 == 1 ? 1 : -1) * sequence[i];

            plus[i] = Math.max(p, p + plus[i-1]);
            minus[i] = Math.max(m, m + minus[i-1]);

            long pm = Math.max(plus[i], minus[i]);
            answer = Math.max(answer, pm);
        }

        return answer;
    }
}
