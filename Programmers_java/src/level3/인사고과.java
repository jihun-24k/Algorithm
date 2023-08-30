package level3;

import java.util.Arrays;

public class 인사고과 {

    public int solution(int[][] scores) {
        int answer = 0;

        int[] wanho = scores[0];
        int sum = wanho[0] + wanho[1];

        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        int maxScore = 0;

        for (int[] score : scores) {
            if (score[1] < maxScore) {
                if (score.equals(wanho)) {
                    return -1;
                }
            }
            else {
                maxScore = Math.max(maxScore, score[1]);
                if (score[0] + score[1] > sum) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
