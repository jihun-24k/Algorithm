package level3;

import java.util.Arrays;

class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int left = 0; // 왼쪽 인덱스
        int right = people.length - 1; // 오른쪽 인덱스

        while (left <= right) {
            // 가장 무거운 사람과 가장 가벼운 사람을 함께 태우기 시도
            if (people[left] + people[right] <= limit) {
                left++; // 왼쪽 인덱스 증가
            }
            right--; // 오른쪽 인덱스 감소
            answer++; // level3.구명보트 수 증가
        }

        return answer;
    }
}
