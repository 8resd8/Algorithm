package _0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_상호의배틀필드_v1 {
    static char[][] map;
    static int H, W, x, y, N;
    static String moving;
    static char[] move = {'U', 'D', 'L', 'F'};
    static char see;

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
//                    System.out.println("위로");
                    up();
                    break;
                case 'D':
//                    System.out.println("아래로");
                    down();
                    break;
                case 'L':
//                    System.out.println("왼쪽");
                    left();
                    break;
                case 'R':
//                    System.out.println("오른쪽");
                    right();
                    break;
                default:
//                    System.out.println("발사");
                    shoot();
                    break;
            }

//            for (char[] chars : map) {
//                System.out.println(Arrays.toString(chars));
//            }
//            System.out.println();
        }
    }

    private static void shoot() {
        // 방향에 따른 좌표설정
        int nx = x;
        int ny = y;

        if (see == '<' && isValid(y, x - 1)) {
            while (--nx >= 0) {
                if (map[ny][nx] == '#') return; // 강철을 만나면 그냥종료

                if (map[ny][nx] == '*') {
                    map[ny][nx] = '.';
                    return;
                }
            }
        } else if (see == '>' && isValid(y, x + 1)) {
            while (++nx < W) {
                if (map[ny][nx] == '#') return;
                if (map[ny][nx] == '*') {
                    map[ny][nx] = '.';
                    return;
                }
            }
        } else if (see == '^') {
            while (--ny >= 0) {
                if (map[ny][nx] == '#') return;

                if (map[ny][nx] == '*') {
                    map[ny][nx] = '.';
                    return;
                }
            }
        } else if (see == 'v' && isValid(y + 1, x)) {
            while (++ny < H) {
                if (map[ny][nx] == '#') return;
                if (map[ny][nx] == '*') {
                    map[ny][nx] = '.';
                    return;
                }
            }
        }
    }

    private static void right() {
        // 오른쪽
        see = '>';

        int ny = y;
        int nx = x + 1;
        if (!isValid(ny, nx)) {
            ny = y;
            nx = x;
        }

        if (map[ny][nx] == '.') {
            // 1-2 오른쪽
            map[y][x] = '.';
            map[ny][nx] = see;

            y = ny;
            x = nx;

            return;
        }

        // 못가는 경우 포탄만 바꿈
        map[y][x] = see;
    }

    private static void left() {
        // 왼쪽 이동
        see = '<';
        int ny = y;
        int nx = x - 1;
        if (!isValid(ny, nx)) {
            ny = y;
            nx = x;
        }

        if (map[ny][nx] == '.') {
            // 1-2 왼쪽 갈 수 있는 경우
            map[ny][nx] = see;
            map[y][x] = '.';
            y = ny;
            x = nx;

            return;
        }

        // 못가는 경우 포탄만 바꿈
        map[y][x] = see;
    }

    private static void down() {
        // 1. 아래로 이동
        // 1-1. 아래 못가는 경우 포탄만 위로 옮김
        see = 'v';
        int ny = y + 1;
        int nx = x;
        if (!isValid(ny, nx)) {
            ny = y;
            nx = x;
        }

        if (map[ny][nx] == '.') {
            // 1-2 아래로 갈 수 있는 경우
            map[ny][nx] = see;
            map[y][x] = '.';
            y = ny;
            x = nx;

            return;
        }

        // 1-2 아래로로 갈 수 있는 경우
        map[y][x] = see;
    }


    private static void up() {
        // 1. 위로 이동
        // 1-1. 위로 못가는 경우 포탄만 위로 옮김
        see = '^';

        int ny = y - 1;
        int nx = x;
        if (!isValid(ny, nx)) {
            ny = y;
            nx = x;
        }

        // 위로 갈 수 있으면
        if (map[ny][nx] == '.') {
            map[ny][nx] = see;
            map[y][x] = '.';
            y = ny;
            x = nx;
            return;
        }

        // 1-2 위로 못가면
        map[y][x] = see;

    }

    private static void init(BufferedReader br) throws IOException {
        String[] HW = br.readLine().split(" ");
        H = Integer.parseInt(HW[0]);
        W = Integer.parseInt(HW[1]);
        map = new char[H][W];

        // 현재의 맵 상태를 입력
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);

                // 현재 전차의 위치를 저장
                if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
                    y = i; // 세로
                    x = j; // 가로
                    see = map[i][j];
                }
            }
        }
        N = Integer.parseInt(br.readLine()); // 움직일 횟수
        moving = br.readLine();
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }
}