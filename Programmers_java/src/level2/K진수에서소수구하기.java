package level2;

public class K진수에서소수구하기 {
    public int solution(int n, int k) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, n%k);
            n /= k;
        }

        String[] arr = sb.toString().split("0");


        for (String a : arr) {
            if (a.equals("")) {
                continue;
            }

            if (isPrime(a)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(String a) {
        long num = Long.parseLong(a);

        if (num == 1)
            return false;
        else if(num == 2)
            return true;
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
