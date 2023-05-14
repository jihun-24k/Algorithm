import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class 여행경로 {
    static HashMap<String, PriorityQueue<String>> routes;
    static List<String> answer;
    static int ticketCnt;

    public String[] solution(String[][] tickets) {
        ticketCnt = tickets.length;
        routes = new HashMap<>();

        for (String[] ticket : tickets) {
            if (!routes.containsKey(ticket[0])) {
                routes.put(ticket[0], new PriorityQueue<>());
            }
            routes.get(ticket[0]).add(ticket[1]);
        }

        answer = new ArrayList<>();
        dfs("ICN");

        String[] result = new String[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private static void dfs(String start) {
        if (answer.size() == ticketCnt + 1) {
            return;
        }
        if (routes.containsKey(start)) {
            PriorityQueue<String> queue = routes.get(start);
            while (!queue.isEmpty()) {
                String next = queue.poll();
                dfs(next);
            }
        }
        answer.add(0, start);
    }
}
