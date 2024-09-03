package _0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_홈방범서비스 {
    static int N, M, totalCount, maxService;
    static int[][] map, visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] NM = br.readLine().split(" ");
            N = Integer.parseInt(NM[0]);
            M = Integer.parseInt(NM[1]);
            map = new int[N][N];
            maxService = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


//             1. (0, 0) ~ (N-1, N-1) 까지 BFS
            totalCount = 0;
            if (tc != 7) continue;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(i, j);
//                    System.out.println(totalCount + ": ------- 다음 -------");
                }
            }

            System.out.printf("#%d %d\n", tc, maxService);
        }

    }

    private static void bfs(int a, int b) {
        // bfs시작 위치에서
        // 최대 거리가 1일때 운영비용, 수익률
        // 최대 거리가 2일때 운영비용, 수익률
        // 최대 거리가 3일때 운영비용, 수익률
        for (int distance = 1; distance <= N; distance++) {

            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{a, b});
            visited = new int[N][N];
            visited[a][b] = 1;
            int costumerCost = 0;
            int costumerCount = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // 운영비용 계산
                if (map[x][y] == 1) {
                    costumerCost += M;   // 고객 수금
                    costumerCount++; // 고객 수
                }

                if (visited[x][y] == distance + 1) {
                    int cost = cost(distance);
                    if (costumerCost - cost < 0) break;
                    System.out.println("x:" + x + ", y: " + y + ", " + distance + ":  " + "거리: " + distance + " 운영비: " + cost + ", 수익 " + costumerCost + " 이득: " + (costumerCost - cost) + " 사람수: " + costumerCount);
                    if (costumerCost >= cost) { // 손해를 보지 않으면서
                        maxService = Math.max(maxService, costumerCount);
                    }
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 범위초과
                    if (visited[nx][ny] != 0) continue; // 방문지점
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[x][y] + 1;

                }
            }

        }

    }

    static int cost(int K) {
        return K * K + (K - 1) * (K - 1);
    }
}
