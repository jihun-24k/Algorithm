public class n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int idx = 0;

        while (left <= right) {
            int num = 0;
            num += Math.max(left / n + 1, left % n + 1);

            answer[idx] = num;
            idx++;
            left++;
        }

        return answer;
    }
}
