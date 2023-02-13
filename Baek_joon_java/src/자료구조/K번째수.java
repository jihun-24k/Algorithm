package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] A, int start, int end, int K) {
        if (start < end) {
            int pivot = findPivot(A, start, end);
            if (pivot == K) {
                return;
            } else if (K < pivot) {
                quickSort(A, start, pivot - 1, K);
            } else {
                quickSort(A, pivot + 1, end, K);
            }
        }
    }

    private static int findPivot(int[] A, int start, int end) {
        if (start + 1 == end) {
            if (A[start] > A[end])
                swap(A, start, end);
            return end;
        }
        int middle = (start + end) / 2;
        swap(A, start, middle);
        int pivot = A[start];

        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (pivot < A[j] && j > 0) {
                j--;
            }
            while (pivot > A[i] && i < A.length - 1) {
                i++;
            }
            if (i <= j) {
                swap(A, i++, j--);
            }
        }
        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
}
