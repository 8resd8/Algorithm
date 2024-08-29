package _0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_Contact {
    static int length, start, answer, index;
    static ArrayList<ArrayList<Integer>> adj;
//    static ArrayList<Integer>[] adj;
//    static HashMap<Integer, int[]> adj;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 0; tc < 10; tc++) {
            String[] lengthStart = br.readLine().split(" ");
            length = Integer.parseInt(lengthStart[0]);
            start = Integer.parseInt(lengthStart[1]);
            visited = new int[101];
            index = 0;
            answer = 0;
            adj = new ArrayList<>();
            for (int i = 0; i < 101; i++) {
                adj.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length / 2; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj.get(a).add(b);
            }

            bfs(start);

            for (int i = 0; i < 101; i++) {
                if (visited[i] == index) answer = i;
            }

            System.out.println("#" + (tc + 1) + " " + answer);
        }
    }

    private static void bfs(int current) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(current);
        visited[current] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Integer next : adj.get(now)) {
                if (visited[next] != 0) continue;

                queue.add(next);
                visited[next] = visited[now] + 1;
                index = visited[next];
            }
        }
    }
}