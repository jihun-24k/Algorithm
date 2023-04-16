public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[500][500];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++){
            for (int j = 0; j < triangle[i].length - 1; j++){
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + triangle[i][j]);
                dp[i][j+1] = Math.max(dp[i][j+1], dp[i-1][j] + triangle[i][j+1]);
            }
        }

        int answer = 0;
        for (int i = 0; i < 500; i++)
            answer = Math.max(answer, dp[height-1][i]);

        return answer;
    }
}
