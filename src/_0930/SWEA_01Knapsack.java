package _0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

            /**

             물건을 넣을때 어떤 것이 유리한가?
             1. 물건을 넣는다 -> 해당 물건의 부피와 가치를 추가한 후 최대 가치 계산
             2. 물건을 넣지 않는다 -> 현재까지 최대 가치와 동일

             dp[i]: 부피 i일때 가능한 최대 가치를 저장.
             dp[0]: 부피가 0일 때 최대 가치는 0, 즉 아무 물건도 없다.
             dp[K]: 최종적으로 구해야 할 답, 최대 부피 K까지 가방의 담을 수 있는 최대 가치

             [선택 과정]
             각각의 물건을 차례로 고려하면서 물건을 넣을지 안 넣을지 결정
             1. 물건을 넣는 경우
             - 부피가 Vi인 물건을 넣는다면 이전 상태에서 dp[i - Vi]의 물건의 가치를 더해줄 수 있다.

             2. 물건을 넣지 않는 경우
             - 해당 부피에서 물건을 추가하지 않으면 이전 상태 dp[i]는 그대로 유지

             첫번째 물건: 부피 1, 가치 2
             dp = [0, 2, 2, 2, 2, 2]

             두번째 물건: 부피 3, 가치 2
             dp = [0, 2, 2, 2, 4, 4]

             세번째 물건: 부피 4, 가치 4
             dp = [0, 2, 2, 2, 4, 6]

             */

            int[] dp = new int[K + 1]; // 인덱스를 부피로 이용
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                V = Integer.parseInt(st.nextToken()); // 부피
                C = Integer.parseInt(st.nextToken()); // 가치
                mono.add(new int[]{V, C});

                for (int j = K; j >= V; j--) { // 5 3
//                    System.out.printf("dp[%d] = Math.max(dp[%d], dp[%d - %d] + %d)\n", j, j, j, V, C);
                    dp[j] = Math.max(dp[j], dp[j - V] + C); // 안넣는값, dp[1] ~ dp[V](기존값) + C(현재값)
                }
//                System.out.println(Arrays.toString(dp));
            }

            System.out.printf("#%d %d\n", tc, dp[K]);
        }
    }

    private static void dfs(int index, int v, int c) {
        maxC = Math.max(maxC, c);
        for (int i = index; i < N; i++) {
            if (mono.get(i)[1] + v <= K) {
                int[] cur = mono.get(i);
                dfs(i + 1, cur[0] + v, cur[1] + c);
            }
        }
    }
}