class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];

        for (int i = 3; i < (brown + yellow) / 2; i++){
            if ((brown+yellow)%i == 0) {
                if ((i*2 + (brown+yellow)/i*2 - 4) == brown) {
                    result[0] = i;
                    result[1] = (brown+yellow)/i;
                }
            }
        }

        return result;
    }
}