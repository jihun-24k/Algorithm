import java.util.Arrays;

class 합승택시요금 {
    static int INF = 200 * 100000 + 1;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;

        // 인접 배열 초기화
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] edge : fares) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = dist[v][u] = w; // 무방향 그래프 이므로 양방향 모두 업데이트
        }

        // 플로이드-와샬 알고리즘을 이용하여 모든 쌍 최단 경로 구하기
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // 출발점(s)을 기준으로 a와 b까지 함께 가는 경우의 최소 요금 찾기
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }

        return answer;
    }
}
