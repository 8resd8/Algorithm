package _0930;

// https://www.acmicpc.net/problem/12865

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물건의 수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가치

            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }

        System.out.println(dp[K]);
    }
}