package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class DNA비밀번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        List<String> DNA = Arrays.asList(st.nextToken().split(""));

        st = new StringTokenizer(bf.readLine());
        List<String> charList = Arrays.asList("A", "C", "G", "T");
        Map<String, Integer> count = new HashMap<>();
        Map<String, Integer> subCharList = new HashMap<>();
        for (String ch : charList) {
            count.put(ch, Integer.valueOf(st.nextToken()));
            subCharList.put(ch, 0);
        }

        for (int i = 0; i < P; i++) {
            subCharList.put(DNA.get(i), subCharList.get(DNA.get(i)) + 1);
        }

        int head = 0;
        int result = 0;
        for (String str : charList) {
            if (subCharList.get(str) < count.get(str)) {
                break;
            }
            if (str.equals("T")) {
                result++;
            }
        }

        for (int i = P; i < S; i++) {
            subCharList.put(DNA.get(i), subCharList.get(DNA.get(i)) + 1);
            subCharList.put(DNA.get(head), subCharList.get(DNA.get(head)) - 1);
            head++;
            for (String str : charList) {
                if (subCharList.get(str) < count.get(str)) {
                    break;
                }
                if (str.equals("T")) {
                    result++;
                }
            }
        }
        System.out.println(result);
        bf.close();
    }
}
