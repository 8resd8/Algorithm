package _0821;

// https://www.acmicpc.net/problem/1992

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_쿼드트리 {
    static int[][] map;
    static int n, sum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        divideSpace(0, 0, n);
        System.out.println(sb);
    }

    private static void divideSpace(int r, int c, int size) {
        int half = size / 2;
        if (size == 1) {
            sb.append(')');
            return;
        }

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                sum += map[i][j];
            }
        }
        if (sum == size) {
            sb.append(1);

        } else if (sum == 0) {
            sb.append(0);

        }
        sum = 0;



        divideSpace(r, c, half);
        divideSpace(r, c + half, half);
        divideSpace(r + half, c, half);
        divideSpace(r + half, c + half, half);
    }
}
