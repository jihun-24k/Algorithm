class Lotto {
    public static int solution(int[][] lotteries) {
        double maxPercent = 0.0;
        int value = 0;
        int result = -1;
        int index = 1;

        for (int[] lotto : lotteries){
            double percent = (double) lotto[0] / (double) (lotto[1] + 1);
            if (maxPercent == percent) {
                if (value < lotto[2]){
                    result = index;
                    value = lotto[2];
                }
            }
            if (maxPercent < percent) {
                result = index;
                value = lotto[2];
                maxPercent = percent;
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] lotteries = {{100, 100, 500},{1000, 1000, 100}};
        System.out.println(solution(lotteries));
    }
}