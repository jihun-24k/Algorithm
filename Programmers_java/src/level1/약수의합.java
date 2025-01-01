package level1;

class 약수의합 {
    public int solution(int n) {
        int answer = 0;
        int num = n;

        while (num > 0) {
            if (n % num == 0) {
                answer += num;
            }
            num--;
        }
        return answer;
    }
}