import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {
    static Queue<Integer> queue;

    public int[] solution(String[] operations) {
       queue = new PriorityQueue<>();

        for (String operation : operations) {
            String[] oper = operation.split(" ");
            if (oper[0].equals("D") && !queue.isEmpty()) {
                if (Integer.parseInt(oper[1]) == 1) {
                    pollReverseQueue();
                }
                if (Integer.parseInt(oper[1]) == -1){
                    pollQueue();
                }
            }
            if (oper[0].equals("I")){
                queue.add(Integer.parseInt(oper[1]));
            }
        }

        int[] answer = new int[]{0,0};
        if (!queue.isEmpty()){
            answer[1] = pollQueue();
            answer[0] = pollReverseQueue();
        }

        return answer;
    }

    private int pollReverseQueue() {
        Queue<Integer> reverseQ = new PriorityQueue<>(Collections.reverseOrder());
        reverseQ.addAll(queue);
        queue = reverseQ;
        return queue.poll();
    }

    private int pollQueue() {
        Queue<Integer> justQ = new PriorityQueue<>();
        justQ.addAll(queue);
        queue = justQ;
        return queue.poll();
    }
}
