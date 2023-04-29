import java.util.*;

class 불량사용자 {
    static Set<Set<String>> answer;

    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();
        Set<String> visited = new HashSet<>();

        backtrack(user_id, banned_id, visited);

        return answer.size();
    }

    private void backtrack(String[] user_id, String[] banned_id, Set<String> visited) {
        if (banned_id.length == visited.size()){
            answer.add(new HashSet<>(visited));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (visited.contains(user_id[i]))
                continue;
            if (compareId(user_id[i], banned_id[visited.size()])) {
                visited.add(user_id[i]);
                backtrack(user_id, banned_id, visited);
                visited.remove(user_id[i]);
            }
        }

    }

    private boolean compareId(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length())
            return false;
        char[] user = user_id.toCharArray();
        char[] banned = banned_id.toCharArray();
        for (int i = 0; i < user_id.length(); i++) {
            if (banned[i] == '*')
                continue;
            if (user[i] != banned[i])
                return false;
        }
        return true;
    }
}
