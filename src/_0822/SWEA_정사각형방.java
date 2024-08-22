package _0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_정사각형방 {
    static int[][] map, visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, maxCount, maxRoom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new int[n][n];
            maxCount = 0;
            maxRoom = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    searchRoom(i, j);
                }
            }

            System.out.println("#" + (tc + 1) + " " + maxRoom + " " + maxCount);
        }
    }

    private static void searchRoom(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        int count = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (map[x][y] + 1 != map[nx][ny]) continue;

                queue.add(new int[]{nx, ny});
            }
        }

        if (maxCount < count) {
            maxCount = count;
            maxRoom = map[a][b];
        } else if (maxCount == count && maxRoom > map[a][b]) {
            maxRoom = map[a][b];
        }
    }
}