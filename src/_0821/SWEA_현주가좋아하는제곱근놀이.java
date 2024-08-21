package _0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_현주가좋아하는제곱근놀이 {
    static int answer;
    static String n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = br.readLine();
            answer = 0;

            dfs(0);
            System.out.printf("#%d %d\n", tc + 1, answer);
        }
    }

    private static void dfs(int count) {
        if (n.equals("2")) {
            answer = count;
            return;
        }


    }
}
