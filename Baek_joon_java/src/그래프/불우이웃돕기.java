package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 불우이웃돕기 {

    static PriorityQueue<LanEdge> edges;
    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        edges = new PriorityQueue<>();
        set = new int[N];
        int wholeLan = 0;
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            set[i] = i;
            for (int j = 0; j < N; j++) {
                int lan = charToInt(row[j]);
                if (i != j && lan != 0) {
                    edges.add(new LanEdge(i, j, lan));
                }
                wholeLan += lan;
            }
        }

        int count = 0;
        int minValue = 0;
        while (!edges.isEmpty()) {
            LanEdge lan = edges.poll();
            int com1 = lan.com1;
            int com2 = lan.com2;
            int len = lan.len;

            if (find(com1) != find(com2)) {
                union(com1, com2);
                count++;
                minValue += len;
            }
        }
        if (count == N - 1) {
            System.out.println(wholeLan - minValue);
        } else {
            System.out.println(-1);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            set[b] = a;
        }
    }

    private static int find(int a) {
        if (set[a] == a) {
            return a;
        }
        return set[a] = find(set[a]);
    }

    private static int charToInt(char c) {
        if (c == '0') {
            return 0;
        }
        if (c >= 'a') {
            return c - 'a' + 1;
        }
        return c - 'A' + 27;
    }
}

class LanEdge implements Comparable<LanEdge> {

    int com1;
    int com2;
    int len;

    LanEdge(int com1, int com2, int len) {
        this.com1 = com1;
        this.com2 = com2;
        this.len = len;
    }


    @Override
    public int compareTo(LanEdge o) {
        return this.len - o.len;
    }
}
