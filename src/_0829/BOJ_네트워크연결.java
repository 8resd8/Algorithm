package _0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_네트워크연결 {
    static int N, M, minCost;
    static int[] parents;
    static Edge[] edges;
    static PriorityQueue<Edge> pq;

    static class Edge implements Comparable<Edge> {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, cost); // 간선 연결
//            pq.add(new Edge(start, end, cost));
        }
//        Arrays.sort(edges); // 정렬해야함

        makeSet(); // 초기화
//        while (!pq.isEmpty()) {
//            Edge edge = pq.
//            if ()
//        }

        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                minCost += edge.cost;
            }
        }

        System.out.println(minCost);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false; // 사이클 발생, 리턴

        if (parents[a] < parents[b]) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }

        return true;
    }

    private static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }
}