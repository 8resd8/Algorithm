package _0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int start, end, cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(cost, o.cost);
    }
}

public class BOJ_녹색옷입은애가젤다지 {
    static int N, testCase;
    static int[][] map, dist;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) return;
            map = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();
            System.out.printf("Problem %d: %d\n", ++testCase, dist[N - 1][N - 1]);
        }
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        pq.add(new Edge(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int s = current.start;
            int e = current.end;
            int cost = current.cost;

            if (s == N - 1 && e == N - 1) return;

            if (visited[s][e]) continue;
            visited[s][e] = true;

            for (int i = 0; i < 4; i++) {
                int nx = s + dx[i];
                int ny = e + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny] || dist[nx][ny] < cost + map[nx][ny]) continue;
                dist[nx][ny] = cost + map[nx][ny];
                pq.add(new Edge(nx, ny, dist[nx][ny]));
            }

        }
    }
}