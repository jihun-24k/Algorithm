import java.util.Arrays;
import java.util.PriorityQueue;

public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> Aq = new PriorityQueue<>();
        PriorityQueue<Integer> Bq = new PriorityQueue<>();

        for (int i = 0; i < A.length; i++) {
            Aq.add(A[i]);
            Bq.add(B[i]);
        }

        while (!Bq.isEmpty()) {
            int a = Aq.poll();

            while (!Bq.isEmpty()) {
                int b = Bq.poll();
                if (a < b) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
