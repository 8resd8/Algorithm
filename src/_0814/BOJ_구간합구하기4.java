package _0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11659

public class BOJ_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[] numbers = new int[N];
        int[] prefixSum = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 입력
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 누적 합 구하기
        for (int i = 1; i <= N; i++) {
            prefixSum[i] += numbers[i - 1] + prefixSum[i - 1];
        }

        // 2. 구간 합 구하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int cumulativeSum = prefixSum[b] - prefixSum[a - 1];
            sb.append(cumulativeSum).append("\n");
        }
        System.out.println(sb);
    }
}