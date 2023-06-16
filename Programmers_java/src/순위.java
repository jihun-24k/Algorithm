public class 순위 {
    public int solution(int n, int[][] results) {
        final int INF = 987654321;
        int[][] graph = new int[n + 1][n + 1];

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }

        // 경기 결과 반영
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = 1;
        }

        // 플로이드-워셜 알고리즘 수행
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int answer = 0;

        // 순위를 확정할 수 있는 플레이어 개수 카운트
        for (int i = 1; i <= n; i++) {
            boolean determined = true;
            for (int j = 1; j <= n; j++) {
                if (i != j && (graph[i][j] == INF && graph[j][i] == INF)) {
                    determined = false;
                    break;
                }
            }
            if (determined) {
                answer++;
            }
        }

        return answer;
    }
}
