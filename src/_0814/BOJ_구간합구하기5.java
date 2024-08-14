package _0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11660
public class BOJ_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[][] prefixSum = new int[N][N + 1];
        int[][] number = new int[N][N];

        // 1. 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                number[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 행마다 구간 합 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N + 1; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + number[i][j - 1];
            }
        }

        // 3. 누적 합 구하기 (가로 값의 누적)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int cumulative = 0;

            for (int j = y1; j < y2; j++) {
                cumulative += prefixSum[j][x2] - prefixSum[j][x1];
            }
            sb.append(cumulative).append("\n");
        }

        System.out.println(sb);
    }
}