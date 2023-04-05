import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    static boolean[][] visited;
    static char[][] map;
    static int toLav = Integer.MAX_VALUE, toEnd = Integer.MAX_VALUE;
    static int mapX, mapY;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
    }

    public static int solution(String[] maps) {
        int sx = 0, sy = 0, lx = 0, ly = 0;
        mapX = maps[0].length();
        mapY = maps.length;

        map = new char[mapY][mapX];
        for (int i = 0; i < mapY; i++) {
            char[] tmp = maps[i].toCharArray();
            for (int j = 0; j < mapX; j++) {
                map[i][j] = tmp[j];
                if (tmp[j] == 'S') {
                    sx = j;
                    sy = i;
                }
                if (tmp[j] == 'L') {
                    lx = j;
                    ly = i;
                }
            }
        }
        int answer = 0;
        visited = new boolean[mapY][mapX];
        bfs(sx, sy);
        if (toLav == Integer.MAX_VALUE)
            return -1;
        else {
            answer += toLav;
        }

        visited = new boolean[mapY][mapX];
        toEnd = Integer.MAX_VALUE;
        bfs(lx, ly);
        if (toEnd == Integer.MAX_VALUE)
            return -1;
        else {
            answer += toEnd;
        }
        return answer;
    }

    private static void bfs(int sx, int sy) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(sx, sy, 0));
        visited[sy][sx] = true;

        while(!queue.isEmpty()) {
            State now = queue.poll();
            int x = now.x;
            int y = now.y;
            int t = now.time;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= mapX || ny < 0 || ny >= mapY) {
                    continue;
                }
                if (visited[ny][nx] || map[ny][nx] == 'X')
                    continue;
                if (map[ny][nx] == 'L'){
                    toLav = Math.min(toLav, t + 1);
                }
                if (map[ny][nx] == 'E') {
                    toEnd = Math.min(toEnd, t + 1);
                }
                visited[ny][nx] = true;
                queue.add(new State(nx, ny, t + 1));
            }
        }
    }
}

class State {
    int x;
    int y;
    int time;
    public State(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
