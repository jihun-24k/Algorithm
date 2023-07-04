package level3;

public class 풍선터트리기 {
    public int solution(int[] a) {
        int answer = 0;

        if (a.length <= 2) {
            return a.length;
        }

        int leftMin = a[0];
        int rightMin = Integer.MAX_VALUE;

        for (int i = 1; i < a.length; i++) {
            if (a[i] < leftMin) {
                answer++;
                leftMin = a[i];
            }
        }

        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < rightMin) {
                answer++;
                rightMin = a[i];
            }
        }

        return answer;
    }
}
