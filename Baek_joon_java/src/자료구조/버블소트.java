package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 버블소트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CompareIndex[] A = new CompareIndex[N];

        for (int i = 0; i < N; i++) {
            A[i] = new CompareIndex(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);
        int max = 0;

        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i) {
                max = A[i].index - i;
            }
        }
        System.out.println(max + 1);
    }


}

class CompareIndex implements Comparable<CompareIndex> {

    int value;
    int index;

    public CompareIndex(int value, int index) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(CompareIndex o) {
        return this.value - o.value;
    }
}
