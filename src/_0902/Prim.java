package _0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {
    static class Edge implements Comparable<Edge> {
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }

    static ArrayList<ArrayList<Edge>> adj;
    static PriorityQueue<Edge> pq;
    static boolean[] visited;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        pq = new PriorityQueue<>();
        visited = new boolean[N];


        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            adj.get(a).add(new Edge(b, cost));
            adj.get(b).add(new Edge(a, cost));
        }

        prim();

    }

    private static void prim() {
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited[edge.node]) continue;

            sum += edge.cost;
            visited[edge.node] = true;

            for (Edge next : adj.get(edge.node)) {
                if (visited[next.node]) continue;
                pq.add(next);
            }
        }

    }
}
