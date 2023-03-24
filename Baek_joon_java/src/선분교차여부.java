import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선분교차여부 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x1 = Integer.parseInt(st.nextToken());
        long y1 = Integer.parseInt(st.nextToken());
        long x2 = Integer.parseInt(st.nextToken());
        long y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Integer.parseInt(st.nextToken());
        long y3 = Integer.parseInt(st.nextToken());
        long x4 = Integer.parseInt(st.nextToken());
        long y4 = Integer.parseInt(st.nextToken());

        boolean cross = isCross(x1, y1, x2, y2, x3, y3, x4, y4);
        if (cross) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean isOverlab(long x1, long y1, long x2, long y2, long x3, long y3, long x4,
        long y4) {
        if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2) &&
            Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2)) {
            return true;
        }
        return false;
    }

    private static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4,
        long y4) {
        int acd = ccw(x1, y1, x3, y3, x4, y4);
        int bcd = ccw(x2, y2, x3, y3, x4, y4);
        int abc = ccw(x1, y1, x2, y2, x3, y3);
        int abd = ccw(x1, y1, x2, y2, x4, y4);

        if (acd * bcd == 0 && abc * abd == 0) {
            return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);
        } else if (acd * bcd <= 0 && abc * abd <= 0) {
            return true;
        }
        return false;
    }

    private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long result = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if (result > 0) {
            return 1;
        }
        if (result < 0) {
            return -1;
        }
        return 0;
    }
}
