import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totals = new HashMap<>();
        Map<String, ArrayList<int[]>> album = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!album.containsKey(genres[i])) {
                ArrayList<int[]> arr = new ArrayList<>();
                arr.add(new int[]{i, plays[i]});
                album.put(genres[i], arr);
            }
            else {
                album.get(genres[i]).add(new int[]{i, plays[i]});
            }
            totals.put(genres[i], totals.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> keySet = new ArrayList<>(totals.keySet());
        keySet.sort((s1, s2) -> totals.get(s2) - totals.get(s1));

        ArrayList<Integer> answerList = new ArrayList<>();
        for (String key : keySet) {
            ArrayList<int[]> arr = album.get(key);
            arr.sort((o1, o2) -> {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            });

            int count = 0;
            for (int[] a : arr) {
                answerList.add(a[0]);
                count++;
                if (count >= 2) {
                    break;
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
