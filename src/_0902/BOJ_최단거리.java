package _0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_최단거리 {
    static class Edge implements Comparable<Edge> {
        int end, cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int V, E, K;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> adj;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = br.readLine().split(" ");
        V = Integer.parseInt(VE[0]);
        E = Integer.parseInt(VE[1]);
        K = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        adj = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()); // start -> end
            int cost = Integer.parseInt(st.nextToken());
            adj.get(start).add(new Edge(end, cost)); // b로가는 가중치
        }


        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        pq.add(new Edge(K, 0));
        dist[K] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (dist[current.end] < current.cost) continue; // 현재 비용이 기록된 것보다 크면 패스

            for (Edge next : adj.get(current.end)) {
                if (dist[next.end] > dist[current.end] + next.cost) {
                    dist[next.end] = dist[current.end] + next.cost;
                    pq.add(new Edge(next.end, dist[next.end])); // 새로운 값으로 갱신
                }
            }
        }
    }
}