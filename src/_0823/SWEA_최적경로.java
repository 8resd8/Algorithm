package _0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_최적경로 {
    static int N, answer;
    static ArrayList<int[]> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            init(br);
            permutation(new ArrayList<>()); // 2 ~ N + 2 까지의 모든 순열
            System.out.printf("#%d %d\n", tc + 1, answer);
        }
    }

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 2];
        visited[0] = visited[1] = true;
        answer = Integer.MAX_VALUE;
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreElements())
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
    }

    private static void permutation(ArrayList<int[]> temp) {
        if (temp.size() == N) {
            temp.add(0, new int[]{list.get(0)[0], list.get(0)[1]}); // 회사 위치
            temp.add(temp.size(), new int[]{list.get(1)[0], list.get(1)[1]}); // 집 위치

            int distance = 0;
            for (int i = 1; i < N + 2; i++) {
                distance += Math.abs(temp.get(i - 1)[0] - temp.get(i)[0]) + Math.abs(temp.get(i - 1)[1] - temp.get(i)[1]);
            }

            temp.remove(0);
            temp.remove(temp.size() - 1);
            answer = Math.min(answer, distance);
            return;
        }

        for (int i = 2; i < N + 2; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp.add(new int[]{list.get(i)[0], list.get(i)[1]});

            permutation(temp);

            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}