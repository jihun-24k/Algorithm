import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> usedWords = new HashSet<>();
        String beforeWord = words[0];
        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (usedWords.contains(words[i]) || !validWord(beforeWord, words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
            }
            else {
                beforeWord = words[i];
                usedWords.add(words[i]);
            }
        }

        return answer;
    }

    public boolean validWord(String word1, String word2) {
        char end = word1.charAt(word1.length() - 1);
        char start = word2.charAt(0);

        return end == start;
    }
}
