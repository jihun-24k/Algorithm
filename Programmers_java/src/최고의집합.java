import java.util.Arrays;

public class 최고의집합 {

    static int[] answer;

    public int[] solution(int n, int s) {
        if (n == 1)
            return new int[]{s};
        if (n > s) {
            return new int[]{-1};
        }
        answer = new int[n];

        dfs(n,s);
        Arrays.sort(answer);
        return answer;
    }

    public void dfs(int n, int s) {
        if (n == 1) {
            answer[0] = s;
            return;
        }
        answer[n-1] = s/n;
        dfs(n - 1, s - s/n);
    }
}
