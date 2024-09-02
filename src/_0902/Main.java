//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class BOJ1753 {
//    static class Node implements Comparable<Node> {
//        int n, cost;
//
//        public Node(int n, int cost) {
//            this.n = n;
//            this.cost = cost;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return this.cost - o.cost;
//        }
//    }
//
//    static int start;
//    static int n, m;
//    static boolean[] visit;
//    static int INF = Integer.MAX_VALUE;
//    static int[] dist;
//    static ArrayList<Node>[] n_list;
//
//    static void Dijkstra(int start) {
//        dist[start] = 0;
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        pq.add(new Node(start, 0));
//        while (!pq.isEmpty()) {
//            Node cur = pq.poll();
//            if (visit[cur.n])
//                continue;
//            visit[cur.n] = true;
//            for (Node node : n_list[cur.n]) {
//                if (dist[node.n] > dist[cur.n] + node.cost) {
//                    dist[node.n] = dist[cur.n] + node.cost;
//                    pq.add(new Node(node.n, dist[node.n]));
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        start = Integer.parseInt(br.readLine());
//        visit = new boolean[n + 1];
//        dist = new int[n + 1];
//        Arrays.fill(dist, INF);
//        n_list = new ArrayList[n + 1];
//        for (int i = 0; i <= n; i++) {
//            n_list[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int s = Integer.parseInt(st.nextToken()) - 1;
//            int d = Integer.parseInt(st.nextToken()) - 1;
//            int w = Integer.parseInt(st.nextToken());
//            n_list[s].add(new Node(d, w));
//        }
//        Dijkstra(start - 1);
//        for (int i = 0; i < n; i++) {
//            if(dist[i] == INF) System.out.println("INF");
//            else System.out.println(dist[i]);
//        }
//    }
//}
