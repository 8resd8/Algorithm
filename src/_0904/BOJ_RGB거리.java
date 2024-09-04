package _0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] home = new int[N][3]; // N개의 R, G, B

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (i == 0) {
                home[i][0] = R;
                home[i][1] = G;
                home[i][2] = B;
                continue;
            }
            // [0] = R, [1] = G, [2] = B
            home[i][0] = Math.min(home[i - 1][1], home[i - 1][2]) + R; // (G, B)의 최소 + R
            home[i][1] = Math.min(home[i - 1][0], home[i - 1][2]) + G; // (R, B)의 최소 + G
            home[i][2] = Math.min(home[i - 1][0], home[i - 1][1]) + B; // (R, G)의 최소 + B
        }
        System.out.println(Math.min(home[N - 1][0], Math.min(home[N - 1][1], home[N - 1][2])));
    }
}