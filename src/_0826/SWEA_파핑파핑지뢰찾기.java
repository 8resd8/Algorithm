package _0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA_파핑파핑지뢰찾기 {
    static int N, answer;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};// 왼쪽 위부터 시계방향ㄷ
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;
            map = new char[N][N];

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = input.charAt(j);
                }
            }

            // 1. 8칸 뚫려있는 지점부터 확인
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && check(i, j)) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            // 2. 나머지 공간은 1클릭 1오픈, 그냥 더해주기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.') {
                        answer++;
                    }
                }
            }


            System.out.printf("#%d %d\n", tc + 1, answer);
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        map[i][j] = '1'; // visited대신 map자체를 바꾸기

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != '.') continue;
                if (check(nx, ny)) { // 다음 8칸이 다 뚫려있는 경우만 추가
                    queue.add(new int[]{nx, ny});
                }
                map[nx][ny] = '1';
            }
        }

    }

    private static boolean check(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (map[nx][ny] == '*') return false;
        }
        return true;
    }
}