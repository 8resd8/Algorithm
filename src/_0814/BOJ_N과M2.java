package _0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_N과M2 {
    static int N, M;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new int[N + 1];

        ArrayList<Integer> temp = new ArrayList<>();
        permutation(temp, 1);
    }

    private static void permutation(ArrayList<Integer> temp, int start) {
        if (temp.size() == M) {
            StringBuilder sb = new StringBuilder();
            for (Integer number : temp) {
                sb.append(number).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = start; i <= N; i++) {
            if (visited[i] == 1) continue;
            temp.add(i);
            visited[i] = 1;

            permutation(temp, i + 1);
            visited[i] = 0;
            temp.remove(temp.size() -1);
        }
    }
}