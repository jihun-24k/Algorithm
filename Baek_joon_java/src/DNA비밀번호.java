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
        List<String> DNA = Arrays.asList(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        List<String> charList = Arrays.asList("A", "C", "G", "T");
        Map<String, Integer> count = new HashMap<>();
        for (String ch : charList) {
            count.put(ch, Integer.valueOf(st.nextToken()));
        }

        for (int i = 0; i < P; ) {
            for (int i = P; i <= S; i++) {
                add();
                delete();
            }
        }

    }

    public static void add() {

    }

    public static void delete() {

    }


}
