package level2;

public class 피로도 {
    static int answer;

    public int solution(int k, int[][] dungeons) {
        answer = -1;

        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited);
        return answer;
    }

    public void dfs(int k, int[][] dungeons, boolean[] visited) {

        int cnt = 0;
        for (boolean v : visited) {
            if (v) {
                cnt++;
            }
        }
        answer = Math.max(cnt - 1, answer);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }
        }
    }
}
