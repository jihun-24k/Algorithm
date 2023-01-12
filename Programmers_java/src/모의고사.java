import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

    public int[] solution(int[] answers) {

        int[] score = new int[3];

        int[] giveUp1 = {1, 2, 3, 4, 5};
        int[] giveUp2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] giveUp3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == giveUp1[i%5]) score[0]++;
            if (answers[i] == giveUp2[i%8]) score[1]++;
            if (answers[i] == giveUp3[i%10]) score[2]++;
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}
