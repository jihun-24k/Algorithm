import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    public static int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private static void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)){
            answer = Math.min(answer, count);
            return ;
        }

        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && compareStr(begin, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }

    }

    private static boolean compareStr(String a, String b) {
        int hit = 0;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) == b.charAt(i))
                hit++;
        }
        return hit == a.length() - 1;
    }
}
