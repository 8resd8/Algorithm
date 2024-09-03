package _0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_홈방범서비스 {
    static int N, M, maxService;
    static int[][] map;
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

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(i, j);
                }
            }

            System.out.printf("#%d %d\n", tc, maxService);
        }
    }

    private static void bfs(int a, int b) {
        for (int K = 1; K <= N + 1; K++) {
            int cost = cost(K);
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];

            queue.add(new int[]{a, b});
            visited[a][b] = true;
            int customerCost = map[a][b] == 1 ? M : 0;
            int customerCount = map[a][b];
            int distance = 1; // 탐색 거리 초기화

            while (!queue.isEmpty() && distance < K) {
                int size = queue.size(); // 현재 거리에 있는 노드 수
                for (int s = 0; s < size; s++) {
                    int[] current = queue.poll();
                    int x = current[0];
                    int y = current[1];

                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;

                        if (map[nx][ny] == 1) {
                            customerCost += M;
                            customerCount++;
                        }
                    }
                }
                distance++;
            }

            if (customerCost >= cost) {
                maxService = Math.max(maxService, customerCount);
            }
        }
    }

    static int cost(int K) {
        return K * K + (K - 1) * (K - 1);
    }
}
