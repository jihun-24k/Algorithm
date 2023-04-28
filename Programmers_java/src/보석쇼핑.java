import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 보석쇼핑 {

    public int[] solution(String[] gems) {
        int total = new HashSet<>(Arrays.asList(gems)).size();
        int[] answer = new int[2];

        int left = 0;
        int right = 0;

        Map<String, Integer> picks = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        while (right < gems.length) {

            picks.put(gems[right], picks.getOrDefault(gems[right], 0) + 1);
            right++;

            while (picks.get(gems[left]) > 1) {
                picks.put(gems[left], picks.get(gems[left]) - 1);
                left++;
            }

            if (total == picks.size() && minLength > right - left) {
                minLength = right - left;
                answer[0] = left + 1;
                answer[1] = right;
            }
        }

        return answer;
    }
}
