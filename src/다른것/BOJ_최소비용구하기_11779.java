package 다른것;

// https://www.acmicpc.net/problem/11779

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_최소비용구하기_11779 {
    static int n, m, startCity, endCity;
    static ArrayList<ArrayList<Edge>> adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 정점 수
        m = Integer.parseInt(br.readLine()); // 간선 수
        adj = new ArrayList<>();
        dist = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj.get(start).add(new Edge(end, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dist[endCity]);
    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startCity, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startCity] = 0;

        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            if (dist[current.end] < current.cost) continue;

            for(Edge next: adj.get(current.end)) {
                if (dist[next.end] > current.cost + next.cost) {
                    dist[next.end] = current.cost + next.cost;
                    pq.add(new Edge(next.end, dist[next.end]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int end, cost;

        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }
}