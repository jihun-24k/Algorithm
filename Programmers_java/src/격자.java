import java.util.LinkedList;
import java.util.Queue;

public class 격자 {
    public int solution(String[] grid) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int output = 0;
        char[][] gridArr = new char[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) {
            gridArr[i] = grid[i].toCharArray();
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length()];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length(); j++) {
                if (i == 0 || j == 0 || j == grid[0].length() - 1 || i == grid.length - 1){
                    if (gridArr[i][j] == '.') {
                        output++;
                        queue.offer(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int k = 0; k< 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if( x>=0 && y >= 0 && x < grid.length && y < grid[0].length()) {
                    if (gridArr[x][y] != '#' && !visited[x][y]) {
                        visited[x][y] = true;
                        output++;
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }

        return grid.length * grid[0].length() - output;
    }
}
