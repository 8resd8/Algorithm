package _0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_현주가좋아하는제곱근놀이 {
    static long answer;
    static long n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = Long.parseLong(br.readLine());
            answer = 0;

            getN();
            System.out.printf("#%d %d\n", tc + 1, answer);
        }
    }

    private static void getN() {
        long count = 0;
        while (true) {
            if (n == 2) {
                answer = count;
                return;
            }
            double sqrt = Math.sqrt(n);
            if (sqrt % 1 == 0.0) {
                n = (long) sqrt;
            } else {
                long a = (int) sqrt + 1;  // 제곱근을 정수로 바꾸고 +1
                long b = a * a; // 제곱시키기
                count += b - n; // 차이를 한번에 더해
                n = b;
                continue;
            }

            count++;
        }

    }
}