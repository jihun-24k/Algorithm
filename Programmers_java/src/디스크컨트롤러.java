import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int idx = 0;
        int count = 0;

        // 요청 시간 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 처리 시간 기준으로 오름차순 우선순위 큐 생성
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (count < jobs.length) {
            // 현재 시간 이하인 작업을 모두 우선순위 큐에 추가
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }

            // 큐가 비어있지 않으면 가장 처리 시간이 짧은 작업을 꺼내서 처리
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                answer += time + job[1] - job[0];
                time += job[1];
                count++;
            }
            // 큐가 비어있으면 시간을 1초 증가시켜서 작업 추가 여부 확인
            else {
                time++;
            }
        }

        return answer / count;
    }
}
