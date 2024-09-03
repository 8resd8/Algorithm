package _0902;

import java.util.*;
import java.io.*;

public class SWEA_벌꿀채취 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            solve(i + 1);
        }
        System.out.print(sb);
    }

    static int N, M, C, arr[][], ans, pot[], maxSum;

    private static void solve(int tc) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        for (int y1 = 0; y1 < N; y1++) {
            for (int x1 = 0; x1 < N-M+1; x1++) {
                for (int x2 = x1+M; x2 < N-M+1; x2++) {
                    ans = Math.max(ans, calc(x1, y1)+calc(x2, y1));
                }
                for (int y2 = y1+1; y2 < N; y2++) {
                    for (int x2 = 0; x2 < N-M+1; x2++) {
                        ans = Math.max(ans, calc(x1, y1)+calc(x2, y2));
                    }
                }
            }
        }

        sb.append("#").append(tc).append(" ").append(ans).append("\n");
    }

    private static int calc(int x, int y) {
        pot = new int[M];
        maxSum = 0;
        for (int i = 0; i < M; i++) {
            pot[i] = arr[y][x+i];
        }
        powerSet(0, 0, 0);
        return maxSum;
    }

    private static void powerSet(int cnt, int honey, int sum) {
        if (cnt == M) {
            if (honey <= C) maxSum = Math.max(maxSum, sum);
            return;
        }
        powerSet(cnt+1, honey, sum);
        powerSet(cnt+1, honey+pot[cnt], sum+pot[cnt]*pot[cnt]);
    }
}