package _0820;

import java.io.IOException;
import java.util.Scanner;

public class SWEA_의석이의우뚝선산 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int N = sc.nextInt();
            int[] number = new int[N];
            for (int i = 0; i < N; i++) {
                number[i] = sc.nextInt();
            }

            int answer = 0;
            int up = 0;
            int down = 0;

            for (int i = 0; i < N - 1; i++) {
                if (number[i] < number[i + 1]) { // 올라감
                    if (down > 0) {
                        answer += up * down; // 올라간것 * 내려감
                        up = 0;
                        down = 0;
                    }
                    up++;
                } else { // 내려감
                    down++;
                }
            }

            if (up > 0 && down > 0) {
                answer += up * down;
            }

            System.out.println("#" + (tc + 1) + " " + answer);
        }
    }
}
