import java.util.Arrays;

class HIndex {
    public int solution(int[] citations) {
        int result = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                result = h;
                break;
            }
        }
        return result;
    }
}