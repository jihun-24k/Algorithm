import java.util.*;

public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();

        int days = 0; // 진행된 날짜를 나타내는 변수
        int deployCount = 0; // 현재 배포할 수 있는 기능 개수를 나타내는 변수

        for (int i = 0; i < progresses.length; i++) {
            // 각 기능마다 개발을 완료하는데 필요한 일수를 계산
            int remainingProgress = 100 - progresses[i];
            int deployDays = remainingProgress / speeds[i];
            if (remainingProgress % speeds[i] != 0) {
                deployDays++;
            }

            // 첫 번째 기능이거나 이전 기능들보다 배포일이 더 큰 경우 배포 가능
            if (i == 0 || deployDays > days) {
                if (deployCount > 0)
                    answerList.add(deployCount);
                days = deployDays;
                deployCount = 1;
            } else {
                deployCount++;
            }
        }

        // 마지막에 남은 기능들 처리
        answerList.add(deployCount);

        // ArrayList를 int 배열로 변환하여 반환
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
