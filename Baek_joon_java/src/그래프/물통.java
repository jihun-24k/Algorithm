package 그래프;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 물통 {

    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int[] now;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();

        visited = new boolean[201][201];

        bfs();
        Collections.sort(answer);
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }

    public static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer.add(now[2]);

        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;

            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;

                if (next[receiver[k]] > now[receiver[k]]) {
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]];
                    next[receiver[k]] = now[receiver[k]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer.add(next[2]);
                    }
                }
            }
        }

    }


}

class AB {

    int A;
    int B;

    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}
