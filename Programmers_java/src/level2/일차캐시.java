package level2;

import java.util.LinkedList;
import java.util.Queue;

public class 일차캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> queue = new LinkedList<>();

        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            if (queue.contains(city)) {
                queue.remove(city);
                queue.add(city);
                answer++;
            }
            else if (queue.size() >= cacheSize) {
                queue.poll();
                queue.add(city);
                answer +=5;
            }
            else {
                queue.add(city);
                answer += 5;
            }
        }

        return answer;
    }
}