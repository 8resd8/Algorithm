package _0820;

// https://www.acmicpc.net/problem/2839

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                answer += N / 5;
                break;
            }
            N -= 3;
            answer++;
        }
        System.out.println(N < 0 ? -1 : answer);
    }
}