package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 여행가자 {

    static int[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        cities = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cities[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            String[] ij = br.readLine().split(" ");
            for (int j = 1; j < ij.length; j++) {
                if (ij[j - 1].equals("1")) {
                    union(i, j);
                }
            }
        }

        String[] plan = br.readLine().split(" ");
        int set = find(Integer.parseInt(plan[0]));
        boolean canGo = true;
        for (String city : plan) {
            if (set != find(Integer.parseInt(city))) {
                System.out.println("NO");
                canGo = false;
                break;
            }
        }
        if (canGo) {
            System.out.println("YES");
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            cities[b] = a;
        }
    }

    private static int find(int a) {
        if (a == cities[a]) {
            return a;
        }
        return cities[a] = find(cities[a]);
    }

}
