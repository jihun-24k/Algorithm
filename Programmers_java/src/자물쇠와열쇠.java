import java.util.*;

class 자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        int[][] newLock = new int[n + 2 * (m - 1)][n + 2 * (m - 1)];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + m - 1][j + m - 1] = lock[i][j];
            }
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateKey(key);
            for (int x = 0; x < n + m - 1; x++) {
                for (int y = 0; y < n + m - 1; y++) {
                    if (insertKey(newLock, key, x, y, m, n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int[][] rotateKey(int[][] key) {
        int m = key.length;
        int[][] rotatedKey = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotatedKey[j][m - 1 - i] = key[i][j];
            }
        }
        return rotatedKey;
    }

    private boolean insertKey(int[][] lock, int[][] key, int x, int y, int m, int n) {
        int[][] tempLock = deepCopy(lock);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tempLock[x + i][y + j] += key[i][j];
            }
        }
        for (int i = m - 1; i < n + m - 1; i++) {
            for (int j = m - 1; j < n + m - 1; j++) {
                if (tempLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] deepCopy(int[][] arr) {
        return Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
    }
}
