package _0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_등산로조성 {
    static int N, K, max, maxCount;
    static int[][] map;
    static int answer = 0;
    static int[] dx = {0, 0, 1, -1}; // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] NK = br.readLine().split(" ");
            N = Integer.parseInt(NK[0]);
            K = Integer.parseInt(NK[1]);
            map = new int[N][N];
            answer = 0;
            max = 0;
            maxCount = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) {
                        dfs(j, i, true, 0);
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, maxCount);
        }
    }

    private static void dfs(int x, int y, boolean act, int count) {
//            if (map[y][x] == max) {
//                maxCount = count;
//                return;
//            }


        System.out.println("x = " + x);
        System.out.println("y = " + y);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (map[y][x] <= map[ny][nx]) { // 이동하는 값이 크고
                if (act) {
                    if (map[ny][nx] - map[y][x] < K) {
                        int temp = map[ny][nx];
                        map[ny][nx] = map[y][x] + 1;
                        act = false;
                        dfs(nx, ny, act, count + 1);
                        act = true;
                        map[y][x] = temp;
                    }
                }
            } else {
                dfs(nx, ny, act, count + 1);
            }
        }
    }
}