package _0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_알파벳 {
    static int R, C, answer, count;
    static char[][] map;
    static boolean[] alpha;
    static int[] dx = {-1, 1, 0, 0}; // 좌 우 상 하
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        answer = 1;
        map = new char[R][C];
        alpha = new boolean['Z' - '0' + 1];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, map[0][0]);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, char c) {
        if (alpha[c - '0']) {
            answer = Math.max(answer, count);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= C || ny < 0 || ny >= R) continue;
            alpha[c - '0'] = true; // 방문
            count++;
            dfs(nx, ny, map[ny][nx]);
            // 지나온 길을 다시 원상복구 시켜줘야한다.
            alpha[c - '0'] = false; // 더 탐색 안하고 돌아오면 다시 미방문 처리
            count--;
        }

    }
}