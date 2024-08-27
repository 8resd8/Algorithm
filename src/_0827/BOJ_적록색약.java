package _0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/10026

public class BOJ_적록색약 {
    static int[][] map;
    static int[][] visited;
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // R = 1, G = 2, B = 3
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == 'R') map[i][j] = 1;
                else if (input.charAt(j) == 'G') map[i][j] = 2;
                else map[i][j] = 3;
            }
        }

        int normal = 0;
        int unique = 0;
        for (int i = 1; i <= 3; i++) {
            visited = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == i && visited[j][k] == 0) {
                        bfs(j, k, i);
                        normal++;
                    }
                }
            }
        }

        // 적록생약
        visited = new int[N][N];
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (map[j][k] != 3 && visited[j][k] == 0) {
                    uniqueBfs(j, k);
                    unique++;
                } else if (map[j][k] == 3 && visited[j][k] == 0) {
                    bfs(j, k, 3);
                    unique++;
                }
            }
        }

        System.out.print(normal + " " + unique);
    }

    private static void bfs(int j, int k, int target) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{j, k});
        visited[j][k] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isVaild(nx, ny) && visited[nx][ny] == 0 && map[nx][ny] == target) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = 1;
                }
            }
        }
    }

    // 적록색약 전용 bfs
    private static void uniqueBfs(int j, int k) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{j, k});
        visited[j][k] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 1과 2는 똑같은 걸로 취급
                if (isVaild(nx, ny) && visited[nx][ny] == 0 && (map[nx][ny] == 1 || map[nx][ny] == 2)) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = 1;
                }
            }
        }
    }

    private static boolean isVaild(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }
}