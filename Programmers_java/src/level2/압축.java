package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 압축 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
    }

    public static int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        char alpha = 'A';
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf(alpha++), i + 1);
        }

        char[] temp = msg.toCharArray();
        String[] str = new String[temp.length];
        for (int i = 0; i< temp.length; i++) {
            str[i] = String.valueOf(temp[i]);
        }

        ArrayList<Integer> arr = new ArrayList<>();

        if (msg.length() == 1) {
            return new int[]{dict.get(str[0])};
        }

        String w = str[0];
        int idx = 1;
        int num = 27;

        while (idx < msg.length()) {
            String c = w + str[idx];
            if (dict.containsKey(w)) {
                if(!dict.containsKey(c)) {
                    dict.put(c, num++);
                    arr.add(dict.get(w));
                    w = str[idx];
                }
                else {
                    w = c;
                }
            }
            idx++;
        }

        arr.add(dict.get(w));

        return arr.stream().mapToInt(i -> i).toArray();
    }
}
