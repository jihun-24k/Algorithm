package level2;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합 {

    static Set<Integer> set;
    static int len;

    public int solution(int[] elements) {
        set = new HashSet<>();
        len = elements.length;

        for (int i = 1; i <= len; i++) {
            sum(elements, i);
        }

        return set.size();
    }

    public void sum(int[] elements, int count) {
        for (int i = 0; i < len; i++) {
            int num = 0;
            for (int j = i; j < i + count; j++) {
                num += elements[j % len];
            }
            set.add(num);
        }
    }
}
