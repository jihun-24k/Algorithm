package 정수론;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class 칵테일 {

    static ArrayList<Node>[] ratos;
    static boolean[] visited;
    static long[] output;
    static long lcm;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();

        ratos = new ArrayList[N];
        visited = new boolean[N];
        output = new long[N];
        lcm = 1;

        for (int i = 0; i < N; i++) {
            ratos[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            ratos[a].add(new Node(b, p, q));
            ratos[b].add(new Node(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }
        output[0] = lcm;
        dfs(0);

        long mgcd = output[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, output[i]);
        }

        for (int i = 0; i < N; i++) {
            bw.write(output[i] / mgcd + " ");
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (Node n : ratos[node]) {
            int next = n.getB();
            if (!visited[next]) {
                output[next] = output[node] * n.getQ() / n.getP();
                dfs(next);
            }
        }
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}


class Node {

    int b;
    int p;
    int q;

    public Node(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}