package _0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_치즈도둑 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            int maxValue = 1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxValue = Math.max(maxValue, map[i][j]);
                }
            }

            int max = 1;
            for (int X = 1; X <= maxValue; X++) {
                if (X == 100) {
                    break;
                }

                visited = new boolean[N][N];
                int count = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j] && map[i][j] > X) {
//                            bfs(i, j, X);
                            dfs(i, j, X);
                            count++;
                        }
                    }
                }
                max = Math.max(max, count);
            }


            System.out.println("#" + (tc + 1) + " " + max);
        }
    }

    private static void dfs(int x, int y, int X) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] <= X) continue;
            dfs(nx, ny, X);
        }
    }

    private static void bfs(int a, int b, int X) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] <= X) continue;
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}