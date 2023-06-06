class 다음큰수 {
    public int solution(int n) {
        int ones = countOne(convertBinary(n));
        int m = n + 1;

        while (ones != countOne(convertBinary(m))) {
            m++;
        }

        return m;
    }

    public String convertBinary(int n) {
        return Integer.toBinaryString(n);
    }

    public int countOne(String binary) {
        char[] arr = binary.toCharArray();
        int count = 0;

        for (char a : arr) {
            if (a == '1') {
                count++;
            }
        }
        return count;
    }
}