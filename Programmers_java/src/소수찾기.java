import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 소수찾기 {
    public int solution(String numbers) {
        if (Integer.parseInt(numbers) <= 1) return 1;

        List<Boolean> primeList = new ArrayList<>(numbers.length());
        primeList.add(0, false);
        primeList.add(1, false);

        for (int i = 2; i < numbers.length(); i++) {
            primeList.add(i, true);
        }

        for(int i=2; (i*i)<= numbers.length(); i++){
            if(primeList.get(i)){
                for(int j = i*i; j<= numbers.length(); j+=i) primeList.set(j, false);
            }
        }

        Set<Integer> combi = new HashSet<>();
        for (int i = 0; i < numbers.length() - 1; i++) {
            for (int j = i + 1; j < numbers.length(); j++) {
                combi.add(Integer.valueOf(numbers.substring(i,j)));
            }
        }

        return (int) combi.stream().filter(i -> !primeList.get(i)).count();
    }
}
