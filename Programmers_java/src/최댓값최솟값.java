import java.util.stream.Stream;

class 최댓값최솟값 {
    public String solution(String s) {
        int[] numbers = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        return numbers[0] + " " +numbers[numbers.length - 1];
    }
}