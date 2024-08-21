import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1952

public class 달팽이 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] map = new int[n][m];

        int n = 5;
        int m = 3;
        int[][] map = new int[n][m];

        int count = 1;
        int direction = 0;
        int x = 0, y = 0;
        while (count <= n * m) {
            map[y][x] = count++;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n || map[ny][nx] != 0) {
                direction = (direction + 1) % 4;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            x = nx;
            y = ny;

        }

        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
    }
}