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
            int[] current = queue.poll();

            if (current[0] == 1) {
                return current[1];
            }

            if (current[0] % 3 == 0 && !visited[current[0] / 3]) {
                queue.add(new int[]{current[0] / 3, current[1] + 1});
                visited[current[0] / 3] = true;
            }
            if (current[0] % 2 == 0 && !visited[current[0] / 2]) {
                queue.add(new int[]{current[0] / 2, current[1] + 1});
                visited[current[0] / 2] = true;
            }

            if (!visited[current[0] - 1]) {
                queue.add(new int[]{current[0] - 1, current[1] + 1});
                visited[current[0] - 1] = true;
            }
        }
        return -1;
    }
}