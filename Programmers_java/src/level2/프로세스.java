package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Task> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Task(i == location, priorities[i]));
        }

        Arrays.sort(priorities);

        int idx = priorities.length - 1;
        while(!queue.isEmpty()) {
            Task now = queue.poll();
            if (now.prior != priorities[idx]) {
                queue.add(now);
            }
            else {
                if (now.isAnswer) {
                    answer = priorities.length - idx;
                    break;
                }
                idx--;
            }
        }

        return answer;
    }
}

class Task {
    boolean isAnswer;
    int prior;

    public Task(boolean isAnswer, int prior) {
        this.isAnswer = isAnswer;
        this.prior = prior;
    }
}
