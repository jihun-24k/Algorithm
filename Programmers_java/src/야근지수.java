import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        long totalWorks = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
            totalWorks += work;
        }

        if (totalWorks < n)
            return 0;

        while (n > 0){
            pq.add(pq.poll() - 1);
            n--;
        }
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}
