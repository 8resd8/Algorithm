package _0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_하나로_프림 {

    static class Edge implements Comparable<Edge> {
        int vertex; // 정점의 번호
        double cost; // 한 정점에 있는 간선의 비용 1-100 1-200 1-300

        public Edge(int vertex, double cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "e=" + vertex +
                    ", cost=" + cost +
                    '}';
        }
    }

    static double answer;
    static boolean[] visited; // 정점의 방문 여부 체크
    static PriorityQueue<Edge> pq; // 간선의 비용으로 정렬하는 우선순위 큐
    static int N;
    static int[] x, y;
    static double E;
    static ArrayList<ArrayList<Edge>> adj; // 인접리스트로 그래프 구조 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            answer = 0.0;
            x = new int[N];
            y = new int[N];
            visited = new boolean[N];
            adj = new ArrayList<>();
            pq = new PriorityQueue<>(); // 간선을 정렬시켜야함

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                adj.add(new ArrayList<>());
                x[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double cost = (Math.pow(x[j] - x[i], 2) + Math.pow(y[j] - y[i], 2)) * E; // 거리
                    adj.get(i).add(new Edge(j, cost)); // 인접리스트로 추가
                    adj.get(j).add(new Edge(i, cost));
                }
            }

            prim(0); // 프림 시작

            System.out.println("#" + tc + " " + Math.round(answer));

        }
    }

    private static void prim(int startVertex) {
        pq.add(new Edge(startVertex, 0));
        int count = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (visited[current.vertex]) {
                continue;
            }
            visited[current.vertex] = true;
            answer += current.cost;
            count++;

            if (count == N -1) break; // MST완성되면 종료

            for (Edge edge : adj.get(current.vertex)) {
                if (visited[edge.vertex]) {
                    continue;
                }
                pq.add(edge);
            }
        }

        System.out.println("count = " + count);
    }
}