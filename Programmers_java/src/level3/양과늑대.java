package level3;

import java.util.ArrayList;

public class 양과늑대 {

    static ArrayList<Integer>[] graph;

    static int[] infos;
    static int max = 0;

    public static void main(String[] args) {
        solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}});
    }

    public static int solution(int[] info, int[][] edges) {
        infos = info;

        graph = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            graph[parent].add(child);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);

        dfs(0, 0, 0, arr);

        return max;
    }

    public static void dfs(int cur, int sheep, int wolf, ArrayList<Integer> arr) {
        sheep += infos[cur] ^ 1;
        wolf += infos[cur];

        if (sheep <= wolf) {
            return;
        }
        max = Math.max(max, sheep);
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(arr);
        list.addAll(graph[cur]);
        list.remove(Integer.valueOf(cur));

        for (int next : list) {
            dfs(next, sheep, wolf, list);
        }
    }
}
