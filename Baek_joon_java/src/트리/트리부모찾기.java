package 트리;

import java.util.ArrayList;
import java.util.Scanner;

public class 트리부모찾기 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        dfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        for (int child : arr[start]) {
            if (!visited[child]) {
                parent[child] = start;
                dfs(child);
            }
        }
    }

}
