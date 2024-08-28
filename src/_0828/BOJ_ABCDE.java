package _0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_ABCDE {
    static int N, M, answer;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        visited = new boolean[N]; // 사람은 0 ~ N - 1
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (answer == 1) break;
        }

        System.out.println(answer);
    }

    private static void dfs(int current, int depth) {
        if (answer == 1) return;
        if (depth == 5) { // A - E까지의 친구, 깊이
            answer = 1;
            return;
        }

        for (Integer next : adj.get(current)) {
            if (visited[next]) continue;

            visited[next] = true;
            dfs(next, depth + 1);
            visited[next] = false;
        }
    }
}