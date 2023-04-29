
public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;
        int start = 1;

        while (start <= n) {
            if (idx < stations.length && start >= stations[idx] - w) {
                // 현재 검사할 구간이 기지국 범위 내에 있다면
                start = stations[idx] + w + 1; // 기지국 다음 위치로 검사할 구간 이동
                idx++; // 다음 기지국 검사
            } else {
                // 현재 검사할 구간에 기지국이 없다면
                answer++; // 기지국 설치
                start += 2 * w + 1; // 다음 검사할 구간으로 이동
            }
        }

        return answer;
    }
}
