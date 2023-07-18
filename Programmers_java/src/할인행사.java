import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

    static Map<String, Integer> wants;

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3,2,2,2,1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        wants = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            cntSale(discount[i]);
        }

        if (compareItem()) {
            answer++;
        }

        for (int i = 0; i < discount.length - 10; i++) {
            String left = discount[i];
            String right = discount[i+10];

            discntSale(left);
            cntSale(right);

            if (compareItem()) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean compareItem() {
        for (Integer i : wants.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void cntSale(String item) {
        if (wants.containsKey(item)) {
            wants.put(item, wants.get(item) - 1);
        }
    }

    public static void discntSale(String item) {
        if (wants.containsKey(item)) {
            wants.put(item, wants.get(item) + 1);
        }
    }
}
