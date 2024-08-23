package _0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_상호의배틀필드_v2 {
    static char[][] map;
    static int H, W, x, y, N;
    static String moving;
    static char see;

    static final int[][] directions = {
            {-1, 0},  // 위 (U)
            {1, 0},   // 아래 (D)
            {0, -1},  // 왼쪽 (L)
            {0, 1}    // 오른쪽 (R)
    };
    static final char[] directionSee = {'^', 'v', '<', '>'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            init(br);
            protoGame();
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc + 1).append(" ");

            for (char[] chars : map) {
                for (char aChar : chars) {
                    sb.append(aChar);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }

    private static void protoGame() {
        for (char status : moving.toCharArray()) {
            switch (status) {
                case 'U':
                    move(0); // 위
                    break;
                case 'D':
                    move(1); // 아래
                    break;
                case 'L':
                    move(2); // 왼쪽
                    break;
                case 'R':
                    move(3); // 오른쪽
                    break;
                default:
                    shoot();
                    break;
            }
        }
    }

    private static void shoot() {
        int dx = 0, dy = 0;
        switch (see) {
            case '^': dy = -1; break;
            case 'v': dy = 1; break;
            case '<': dx = -1; break;
            case '>': dx = 1; break;
        }

        int nx = x;
        int ny = y;

        while (true) {
            nx += dx;
            ny += dy;

            if (!isValid(ny, nx)) return;

            if (map[ny][nx] == '#') return; // 강철을 만나면 종료
            if (map[ny][nx] == '*') { // 벽돌을 만나면 파괴
                map[ny][nx] = '.';
                return;
            }
        }
    }

    private static void move(int dir) {
        see = directionSee[dir];
        int nx = x + directions[dir][1];
        int ny = y + directions[dir][0];

        // 값이 인덱스 안이고 평지라면 이동
        if (isValid(ny, nx) && map[ny][nx] == '.') {
            map[y][x] = '.';
            x = nx;
            y = ny;
        }

        map[y][x] = see; // 방향만 바꿈
    }

    private static void init(BufferedReader br) throws IOException {
        String[] HW = br.readLine().split(" ");
        H = Integer.parseInt(HW[0]);
        W = Integer.parseInt(HW[1]);
        map = new char[H][W];

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
                    y = i;
                    x = j;
                    see = map[i][j];
                }
            }
        }
        N = Integer.parseInt(br.readLine());
        moving = br.readLine();
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }
}