package _0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Professional_키순서3 {
    static int N, M, cnt;
    static int[][] map, rMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];
            rMap = new int[N + 1][N + 1];
            int answer = 0;

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                rMap[b][a] = map[a][b] = 1;
            }

            for (int i = 1; i <= N; i++) {
                cnt = 0;
                dfs(i, new boolean[N + 1], map);
                dfs(i, new boolean[N + 1], rMap);
                if (cnt == N - 1) answer++;

            }
            System.out.println("#" + tc + " " + answer);
        }

    }

    private static void dfs(int cur, boolean[] visited, int[][] map) {
        visited[cur] = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && map[cur][i] != 0) {
                dfs(i, visited, map);
                cnt++; // 나보다 큰, 작은 대상 카운트
            }
        }
    }
}