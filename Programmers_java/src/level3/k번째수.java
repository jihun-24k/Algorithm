package level3;

import java.util.stream.IntStream;

public class k번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int j = 0;

        for (int[] command : commands) {
            int from = command[0] - 1;
            int to = command[1];
            int idx = command[2] - 1;

            int[] sliceArray = IntStream.range(from, to).map(i -> array[i]).sorted().toArray();
            result[j++] = sliceArray[idx];
        }

        return result;
    }
}
