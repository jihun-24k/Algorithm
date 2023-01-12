import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class 위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> wearings = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (!wearings.containsKey(clothes[i][1])) {
                wearings.put(clothes[i][1], 0);
            }
            wearings.put(clothes[i][1], wearings.get(clothes[i][1]) + 1);
        }

        Iterator<Integer> it = wearings.values().iterator();
        int answer = 1;

        while(it.hasNext())
            answer *= it.next().intValue() + 1;

        return answer;
    }
}