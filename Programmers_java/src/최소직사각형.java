public class 최소직사각형 {

    public int solution(int[][] sizes) {
        int xLen = 0;
        int yLen = 0;

        for (int[] rowCol : sizes) {
            int x = rowCol[0];
            int y = rowCol[1];

            if (x > y) {
                xLen = Math.max(x, xLen);
                yLen = Math.max(y, yLen);
            } else {
                xLen = Math.max(y, xLen);
                yLen = Math.max(x, yLen);
            }
        }
        return xLen * yLen;
    }
}
