public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        for (int time : times) {
            answer = Math.max(answer, time);
        }

        long left = 1;
        long right = answer * n;

        while (left <= right) {
            long mid = (left +right) / 2;
            long person = 0;

            for (int time : times) {
                person += mid/time;
            }

            if (person < n) {
                left = mid + 1;
            }
            if (person >= n) {
                right = mid - 1;
            }
        }

        answer = left + 1;
        return answer;
    }
}
