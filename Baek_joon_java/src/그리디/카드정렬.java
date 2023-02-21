package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cardDummy = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            cardDummy.add(Integer.parseInt(br.readLine()));
        }

        int card1 = 0;
        int card2 = 0;
        int sum = 0;
        while (cardDummy.size() != 1) {
            card1 = cardDummy.remove();
            card2 = cardDummy.remove();
            sum += card1 + card2;
            cardDummy.add(card1 + card2);
        }
        System.out.println(sum);
    }
}
