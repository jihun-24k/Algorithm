package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블소트플레티넘 {

    public static int[] arr, tmp;
    public static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        tmp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, N);
        System.out.println(result);
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int k = start;
        int idx1 = start;
        int idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= end) {
            if (tmp[idx1] > tmp[idx2]) {
                arr[k] = tmp[idx2];
                result += idx2 - k;
                idx2++;
            } else {
                arr[k] = tmp[idx1];
                idx1++;
            }
            k++;
        }

        while (idx1 <= mid) {
            arr[k] = tmp[idx1];
            k++;
            idx1++;
        }

        while (idx2 <= end) {
            arr[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}
