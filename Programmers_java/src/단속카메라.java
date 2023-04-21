import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {

    public int solution(int[][] routes) {
        int answer = 1;
        int camera = 30000;

        Arrays.sort(routes, Comparator.comparingInt(o -> o[0]));

        for (int[] route : routes) {

            int start = route[0];
            int end = route[1];

            if (start > camera) {
                answer++;
                camera = end;
            }
            camera = Math.min(camera, end);
        }
        return answer;
    }
}
