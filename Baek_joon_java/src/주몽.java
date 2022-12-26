import java.util.Arrays;
import java.util.Scanner;

public class 주몽 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] armorMaterial = new int[N];

        for (int i = 0; i < N; i++) {
            armorMaterial[i] = sc.nextInt();
        }

        Arrays.sort(armorMaterial);
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (armorMaterial[i] + armorMaterial[j] == M) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
