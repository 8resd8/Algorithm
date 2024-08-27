package _0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_작업순서 {
    static int V, E;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> adj;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            init(br);
/*
(4 1), (1 2), (2 3), (2 7), (5 6), (7 6), (1 5), (8 5), (8 9)

     1 -> 5 <- 8 -> 9
4 -> 1 -> 2 -> 3
          2 -> 7 -> 6
*/
            solve();
            print(tc);
        }
    }

    private static void solve() {
        // 진입차수가 0인 값을 큐에 넣는다
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < V + 1; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        // 위상정렬 수행
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            result.add(curNode);

            for (Integer nextNode : adj.get(curNode)) {
                inDegree[nextNode]--;
                if (inDegree[nextNode] == 0) queue.add(nextNode);
            }
        }
    }

    private static void init(BufferedReader br) throws IOException {
        String[] VE = br.readLine().split(" ");
        V = Integer.parseInt(VE[0]); // 정점의 개수
        E = Integer.parseInt(VE[1]); // 간선의 개수
        inDegree = new int[V + 1];
        adj = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < E; i++) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b); // a -> b 방향 설정
            inDegree[b]++; // b의 진입 차수 올리기
        }
    }

    private static void print(int tc) {
        System.out.print("#" + tc + " ");
        for (Integer node : result) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}