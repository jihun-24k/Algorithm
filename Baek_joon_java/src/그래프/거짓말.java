package 그래프;

import java.util.Scanner;

public class 거짓말 {

    static int[] people;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int danger = sc.nextInt();

        int[] knownPeople = new int[danger];
        for (int i = 0; i < danger; i++) {
            knownPeople[i] = sc.nextInt();
        }

        people = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            people[i] = i;
        }

        int[] party = new int[M];
        for (int i = 0; i < M; i++) {
            int partyPeople = sc.nextInt();
            int firstPerson = sc.nextInt();
            party[i] = firstPerson;
            for (int j = 0; j < partyPeople - 1; j++) {
                union(firstPerson, sc.nextInt());
            }
        }

        boolean canSpeak = true;
        int result = 0;
        for (int person : party) {
            for (int knowPerson : knownPeople) {
                if (checkSum(person, knowPerson)) {
                    canSpeak = false;
                    break;
                }
            }
            if (canSpeak)
                result++;
            canSpeak = true;
        }
        System.out.println(result);
    }

    private static boolean checkSum(int a, int b) {
        return find(a) == find(b);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            people[b] = a;
        }
    }

    private static int find(int a) {
        if (people[a] == a) {
            return a;
        }
        return people[a] = find(people[a]);
    }
}
