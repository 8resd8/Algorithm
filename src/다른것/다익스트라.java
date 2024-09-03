package 다른것;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라 {

    static class Edge implements Comparable<Edge>{
        int end, cost;

        public Edge(int end, int cost) {
            super();
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }


    }

    static ArrayList<ArrayList<Edge>> adj;
    static PriorityQueue<Edge> pq;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        adj = new ArrayList<>();
        dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq = new PriorityQueue<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj.get(from).add(new Edge(to, cost));
        }

        dijkstra(start);
        System.out.println(Arrays.toString(dist));
        if (dist[end] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[end]);
        }

    }

    private static void dijkstra(int start) {
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            if (dist[current.end] < current.cost) continue;

            for (Edge next: adj.get(current.end)) {
                if (dist[next.end] > current.cost + next.cost) {
                    dist[next.end] = current.cost + next.cost;
                    pq.add(new Edge(next.end, dist[next.end]));
                }
            }
        }

    }
}


/*
6 11
0 5
0 1 3
0 2 5
1 2 2
1 3 6
2 1 1
2 3 4
2 4 6
3 4 2
3 5 3
4 0 3
4 5 6

output==> 12


5 4
0 3
0 1 5
1 2 2
3 2 6
4 3 10

output==> -1



10 17
0 9
0 1 4
0 2 6
1 3 9
1 4 8
2 1 3
2 4 2
2 5 3
3 6 6
4 3 2
4 5 1
4 6 3
4 7 7
5 7 4
5 8 8
6 9 13
7 9 9
8 9 4

output ==>21


 * */

