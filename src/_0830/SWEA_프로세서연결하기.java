package _0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_프로세서연결하기 {
    static int N, minWire, maxCore;
    static ArrayList<int[]> cores;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init(br);
            connect(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(minWire).append("\n");
        }
        System.out.println(sb);
    }

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        cores = new ArrayList<>();
        map = new int[N][N];
        minWire = Integer.MAX_VALUE;
        maxCore = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0 || j == 0 || i == N - 1 || j == N - 1) continue;
                if (map[i][j] == 1) {
                    cores.add(new int[]{i, j});
                }
            }
        }
    }

    private static void connect(int index, int wireCount, int core) { // 끝까지 확인할 인덱스, 현재 전선, 현재 코어수
        if (index == cores.size()) { // 모든 코어를 확인했을때
            if (maxCore < core) { // 지금 코어가 더 많을때
                minWire = wireCount; // 전선 길이 저장
                maxCore = core;
            } else if (maxCore == core) {
                minWire = Math.min(minWire, wireCount);
            }
            return;
        }

        int x = cores.get(index)[0];
        int y = cores.get(index)[1];

        for (int i = 0; i < 4; i++) { // 1개의 코어 방향
            int nowCount = 0;
            int nx = x;
            int ny = y;

            // 한쪽 방향으로 쭉 가는 반복문
            while (true) {
                nx += dx[i];
                ny += dy[i];

                // 만약 끝에 도달한다면 멈추기
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    break;
                }

                // 이미 연결되어 있는 전선 또는 코어에 부딪힌 경우
                if (map[nx][ny] == 1) {
                    nowCount = 0;
                    break;
                }
                nowCount++;
            }

            // 만약 한쪽 방향으로 쭉 갔는데 부딪히거나 코어에 닿아서 중지된 경우
            if (nowCount == 0) {
                connect(index + 1, wireCount, core); // 다음 코어 탐색
                continue;
            }

            // 어딘가에 전선 뻗기 성공, 기록 저장
            int fillX = x;
            int fillY = y;
            for (int j = 0; j < nowCount; j++) {
                fillX += dx[i];
                fillY += dy[i];
                map[fillX][fillY] = 1;
            }
            connect(index + 1, wireCount + nowCount, core + 1);

            // 돌아오면 기록 원상복구
            fillX = x;
            fillY = y;
            for (int j = 0; j < nowCount; j++) {
                fillX += dx[i];
                fillY += dy[i];
                map[fillX][fillY] = 0;
            }


        }
    }
}