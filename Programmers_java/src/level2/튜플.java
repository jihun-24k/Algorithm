package level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class 튜플 {

    static ArrayList<ArrayList<Integer>> arr;

    public int[] solution(String s) {

        arr = parseTuples(s);
        arr.sort(Comparator.comparingInt(ArrayList::size));

        Set<Integer> answer = new LinkedHashSet<>();
        for (ArrayList<Integer> a : arr) {
            answer.addAll(a);
        }

        int[] ans = new int[answer.size()];
        int i = 0;
        for (int a : answer) {
            ans[i++] = a;
        }

        return ans;
    }

    public ArrayList<ArrayList<Integer>> parseTuples(String input) {
        ArrayList<ArrayList<Integer>> tuples = new ArrayList<>();

        // 중괄호와 쉼표를 제거하고 숫자 부분만 남김
        String[] elements = input.replace("{{", "").replace("}}", "").split("},\\{");

        // 각 튜플을 정수 리스트로 변환하여 tuples에 추가
        for (String element : elements) {
            ArrayList<Integer> tuple = new ArrayList<>();

            String[] numbers = element.split(",");
            for (String number : numbers) {
                tuple.add(Integer.parseInt(number));
            }

            tuples.add(tuple);
        }

        return tuples;
    }
}