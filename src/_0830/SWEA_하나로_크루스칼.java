package _0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_하나로_크루스칼 { // 크루스칼

    static class Edge implements Comparable<Edge> {
        int start, end;
        double cost;

        public Edge(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(cost, o.cost);
        }
    }

    static double E;
    static double answer;
    static int N;
    static int[] x, y, parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init(br);
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double cost = ((long) (x[i] - x[j]) * (x[i] - x[j]) +
                            ((long) y[i] - y[j]) * (y[i] - y[j]))
                            * E;
                    pq.add(new Edge(i, j, cost));
                }
            }

            while (!pq.isEmpty()) {
                Edge edge = pq.poll();

                if (union(edge.start, edge.end)) {
                    answer += edge.cost;
                }
            }


            System.out.println("#" + tc + " " + Math.round(answer));
        }
    }

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        E = 0;
        answer = 0;
        x = new int[N];
        y = new int[N];
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            y[i] = Integer.parseInt(st.nextToken());
        }
        E = Double.parseDouble(br.readLine());
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        parent[b] = a;
        return true;
    }


    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    private static boolean check(int a, int b) {
        return find(a) == find(b);
    }
}
