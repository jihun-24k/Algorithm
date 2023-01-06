import java.util.HashMap;
import java.util.Map;

class 전화번호목록 {
    public boolean solution(String[] phone_book) {

        Map<String, Integer> phone_numbers = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            phone_numbers.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++)
            for (int j = 0; j < phone_book[i].length(); j++)
                if (phone_numbers.containsKey(phone_book[i].substring(0, j)))
                    return false;

        return true;
    }
}