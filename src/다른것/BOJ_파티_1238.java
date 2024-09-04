package 다른것;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_파티_1238 {
    static class Edge implements Comparable<Edge> {
        int end, cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }

    static int N, M, X, getTime;
    static ArrayList<ArrayList<Edge>> adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점
        M = Integer.parseInt(st.nextToken()); // 간선
        X = Integer.parseInt(st.nextToken()); // 비용

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 1번부터 N번 마을
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj.get(start).add(new Edge(end, cost));
        }

        dijkstra(1);
        dijkstra(N);
        System.out.println(getTime);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (dist[current.end] < current.cost) continue;

            for (Edge next : adj.get(current.end)) {
                if (dist[next.end] > current.cost + next.cost) {
                    dist[next.end] = current.cost + next.cost;
                    pq.add(new Edge(next.end, dist[next.end]));
                }
            }
        }

        for (int i : dist) {
            System.out.print(i + " ");
        }
        System.out.println();
        if (start == 1) getTime += dist[N];
        else getTime += dist[1];

    }
}