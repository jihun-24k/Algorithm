public class 숫자표현 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int j = i;
            while (sum <= n) {
                sum += j++;
                if(sum == n) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
