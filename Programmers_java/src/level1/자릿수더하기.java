package level1;

public class 자릿수더하기 {
    public int solution(int n) {
        int sum = 0;

        // 숫자를 문자열로 변환
        String str = String.valueOf(n);

        // 각 문자(숫자)를 순회하며 합산
        for (char digit : str.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }

        return sum;
    }
}
