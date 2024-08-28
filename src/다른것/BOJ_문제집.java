package 다른것;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_문제집 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        inDegree = new int[N + 1];
        adj = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b); // a -> b
            inDegree[b]++;
        }

        // 기본적으로 오름차순 우선순위 큐, 쉬운 문제부터 해결
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            result.add(curNode);

            for (Integer nextNode : adj.get(curNode)) {
                inDegree[nextNode]--;
                if (inDegree[nextNode] == 0) queue.add(nextNode);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer node : result) {
            sb.append(node).append(" ");
        }
        System.out.println(sb);
    }
}