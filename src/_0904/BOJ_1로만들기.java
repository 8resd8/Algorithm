package _0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(bfs(Integer.parseInt(br.readLine())));
    }

    private static int bfs(int start) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[1000001];
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == 1) {
                return cur[1];
            }

            if (cur[0] % 3 == 0 && !visited[cur[0] / 3]) {
                queue.add(new int[]{cur[0] / 3, cur[1] + 1});
                visited[cur[0] / 3] = true;
            }
            if (cur[0] % 2 == 0 && !visited[cur[0] / 2]) {
                queue.add(new int[]{cur[0] / 2, cur[1] + 1});
                visited[cur[0] / 2] = true;
            }

            if (!visited[cur[0] - 1]) {
                queue.add(new int[]{cur[0] - 1, cur[1] + 1});
                visited[cur[0] - 1] = true;
            }
        }
        return -1;
    }
}