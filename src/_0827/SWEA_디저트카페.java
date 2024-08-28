package _0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_디저트카페 {
    static int[][] arr;
    static boolean[][] visited;
    static int N, result;
    static int[] dx = {-1, 1, 1, -1};
    static int[] dy = {1, 1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    HashSet<Integer> set = new HashSet<>();
                    dfs(j, i, 1, j, i, set);
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int d, int startX, int startY, HashSet<Integer> set) {
        if (set.size() >= 4 && x == startX && y == startY) {
            result = Math.max(result, set.size());
            return;
        }

        // 이동
        for (int i = 0; i < 2; i++) {
            int nd = d + i; // 지금 방향을 유지하거나 방향을 하나 바꾸기
            if (nd > 4) continue; // 다시 왼쪽 밑으로는 못감

            int nx = x + dx[nd - 1];
            int ny = y + dy[nd - 1];

            if (check(nx, ny) && !visited[ny][nx] && !set.contains(arr[ny][nx])) {
                visited[ny][nx] = true;
                set.add(arr[ny][nx]);
                dfs(nx, ny, nd, startX, startY, set);
                visited[ny][nx] = false;
                set.remove(arr[ny][nx]);
            }
        }
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
