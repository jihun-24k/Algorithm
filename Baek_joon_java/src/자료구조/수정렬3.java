package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬3 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        radixSort(arr, 5);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] arr, int max) {
        int[] output = new int[arr.length];
        int digit = 1;
        int count = 0;
        while (count != max) {
            int[] bucket = new int[10];
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / digit) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                output[bucket[(arr[i] / digit % 10)] - 1] = arr[i];
                bucket[(arr[i] / digit) % 10]--;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            digit *= 10;
            count++;
        }
    }
}
