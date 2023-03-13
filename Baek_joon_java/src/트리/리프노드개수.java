package 트리;

import java.util.ArrayList;
import java.util.Scanner;

public class 리프노드개수 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    static int remove, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        int root = 0;
        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                root = i;
            } else {
                arr[parent].add(i);
            }
        }

        remove = sc.nextInt();

        dfs(root);
        System.out.println(result);
    }

    private static void dfs(int start) {
        boolean isleaf = true;
        visited[start] = true;
        for (int child : arr[start]) {
            if (!visited[child] && child != remove) {
                dfs(child);
                isleaf = false;
            }
        }
        if (isleaf) {
            result++;
        }
    }
}
