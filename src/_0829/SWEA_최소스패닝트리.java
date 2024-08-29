package _0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV_mSnmKUckDFAWb&solveclubId=AZC1NpTagf0DFAVs&problemBoxTitle=0829&problemBoxCnt=3&probBoxId=AZGcU3SKwMQDFAXd

public class SWEA_최소스패닝트리 {

    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static int V, E;
    static long weight;
    static int[] parents;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] VE = br.readLine().split(" ");
            V = Integer.parseInt(VE[0]);
            E = Integer.parseInt(VE[1]);
            edges = new Edge[E]; // 간선의 개수만큼 생성
            weight = 0;

            for (int i = 0; i < E; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(start, end, weight);
            }
            Arrays.sort(edges);
            makeSet();

            for (Edge edge : edges) {
                if (union(edge.start, edge.end)) {
                    weight += edge.weight;
                }
            }

            System.out.println("#" + tc + " " + weight);
        }
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;

        parents[a] = b;
        return true;
    }

    private static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static void makeSet() {
        parents = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }
}