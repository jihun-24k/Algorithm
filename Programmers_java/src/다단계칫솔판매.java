import java.util.HashMap;

public class 다단계칫솔판매 {

    static HashMap<String, Person> group;
    int[] answer;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int people = enroll.length;
        int sells = seller.length;

        answer = new int[people];
        group = new HashMap<>();

        for (int i = 0; i < people; i++) {
            group.put(enroll[i], new Person(i, referral[i]));
        }

        for (int i = 0; i < sells; i++) {
            distributeIncome(seller[i], amount[i] * 100);
        }

        return answer;
    }

    private void distributeIncome(String person, int income) {
        if (person.equals("-")) {
            return;
        }

        Person p = group.get(person);
        int share = (int) Math.floor(income * 0.1); // 소수 이하 버림
        int remain = income - share;

        answer[p.idx] += remain;

        if (share > 0)
            distributeIncome(p.recommender, share);
    }
}

class Person {
    int idx;
    String recommender;

    public Person(int idx, String recommender) {
        this.idx = idx;
        this.recommender = recommender;
    }
}
