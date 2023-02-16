package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {

    static int N, M;
    static int[][] miro;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] arr = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(arr[j]);
            }
        }

        bfs(0, 0);
        System.out.println(miro[N - 1][M - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            visited[index[0]][index[1]] = true;

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + index[0];
                int ny = dy[k] + index[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (miro[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        miro[nx][ny] = miro[index[0]][index[1]] + 1;
                    }
                }
            }
        }
    }
}
