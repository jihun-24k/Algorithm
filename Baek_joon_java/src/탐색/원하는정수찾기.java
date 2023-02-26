package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 원하는정수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int findNum = Integer.parseInt(st.nextToken());

            boolean isfind = false;
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = (end + start) / 2;
                if (arr[mid] == findNum) {
                    isfind = true;
                    break;
                }
                if (arr[mid] < findNum) {
                    start = mid + 1;
                }
                if (arr[mid] > findNum) {
                    end = mid - 1;
                }
            }
            System.out.println(isfind ? 1 : 0);
        }


    }
}
