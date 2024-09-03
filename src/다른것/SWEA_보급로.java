package 다른것;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA_보급로 {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                char[] charArray = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = charArray[j] - '0';
                }
            }


            System.out.println("#" + tc + " " + dijkstra(0, 0));
        }
    }

    static int dijkstra(int start, int end) {
        final int INF = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[N][N];
        int[][] dist = new int[N][N];
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); // r, c, time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2])); // r, c, time

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }

        dist[start][end] = 0;
        pq.add(new int[]{start, end, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // start, end, cost

            if (dist[current[0]][current[1]] < current[2]) continue;

            if (visited[current[0]][current[1]]) continue;
            visited[current[0]][current[1]] = true;

            if (current[0] == N - 1 && current[1] == N - 1) { // 목적지 도달, 도착
                return current[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                if (dist[nx][ny] > current[2] + map[nx][ny]) {
                    dist[nx][ny] = current[2] + map[nx][ny];
                    pq.offer(new int[] {nx, ny, dist[nx][ny]});
                }
            }
        }

        return  -1;
    }
}