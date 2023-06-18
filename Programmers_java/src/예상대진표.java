public class 예상대진표 {
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while (true) {
            answer++;
            if (a % 2 == 0 && a - 1 == b) {
                break;
            }
            if (a % 2 == 1 && a + 1 == b) {
                break;
            }
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
        }

        return answer;
    }
}
