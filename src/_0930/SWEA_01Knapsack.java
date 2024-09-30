package _0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_01Knapsack {
    static int N, K, V, C, maxC;
    static List<int[]> mono;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        mono = new ArrayList<>();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 개수
            K = Integer.parseInt(st.nextToken()); // 최대 부피의 합
            maxC = 0; // 최대 가치
            int[] dp = new int[K];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                V = Integer.parseInt(st.nextToken()); // 부피
                C = Integer.parseInt(st.nextToken()); // 가치
                mono.add(new int[]{V, C});

                dp[i] = Math.max(dp[i], C + dp[i]);
            }
            // dp[i]는 부피i일 때 가질 수 있는 최대 가치.
            // 큰 부피부터 DP테이블 갱신
            // 최대 부피가 K일때 dp[i], i는 0부터 K까지



            dfs(0, 0, 0);
            System.out.printf("#%d %d\n", tc, maxC);
        }

    }

    private static void dfs(int index, int v, int c) {
        maxC = Math.max(maxC, c);

        for (int i = index; i < N; i++) {
            int[] cur = mono.get(i);
            if (cur[1] + v <= K) {
                dfs(i + 1, cur[0] + v, cur[1] + c);
            }
        }
    }
}