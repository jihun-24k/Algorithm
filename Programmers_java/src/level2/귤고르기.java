package level2;

import java.util.*;

public class 귤고르기 {

    static LinkedHashMap<Integer, Integer> mandarin = new LinkedHashMap<>();

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        initData(tangerine);
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(mandarin.entrySet());
        Collections.sort(entryList, (a, b) -> b.getValue().compareTo(a.getValue()));
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : entryList) {
            count += entry.getValue();
            answer++;
            if (count >= k) {
                break;
            }
        }

        return answer;
    }

    private void initData(int[] tangerine) {
        for (int t : tangerine) {
            mandarin.put(t, mandarin.getOrDefault(t, 0) + 1);
        }
    }
}
