import java.util.Arrays;

public class 최소공배수 {
    public int solution(int[] arr) {
        int answer = 0;
        boolean tf = true;
        Arrays.sort(arr);

        while (tf) {
            answer += arr[arr.length - 1];
            for (int a : arr) {
                if (answer % a != 0) {
                    tf = true;
                    break;
                }
                tf = false;
            }
        }

        return answer;
    }
}
