package _0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_빵집 {
    static char[][] map;
    static int[][] visited;
    static int r, c, count;
    static int[] dy = {1, 1, 1};
    static int[] dx = {-1, 0, 1}; // 오른쪽 위, 오른쪽, 오른쪽 아래
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        map = new char[r][c];
        visited = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            flag = false; // 초기화
            dfs(i, 0);
        }
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        if (flag) return; // 도착하면 모든 가지들 쳐내기

        if (y == c - 1) {
            count++;
            flag = true;
            return;
        }

        visited[x][y] = 1;

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i]; // 오른쪽 위부터
            int ny = y + dy[i];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if (map[nx][ny] == '.' && visited[nx][ny] == 0) {
//                visited[nx][ny] = 1;
//                if (flag) return;
                dfs(nx, ny);
                // 여기서 visited 처리하면 안돼.
            }

        }
    }
}