package _0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 최초: 모든 간선을 가중치에 따라 오름차순 정렬
// 가중치가 가장 낮은 간선부터 선택하며 트리를 증가
// ㄴ 사이클이 존재하면 남아있는 간선 중 다음으로 낮은 가중치 선택
// n - 1개의간선이 선택 될 때까지 반복

public class 수업_크루스칼 {
    static int[] parent, rank;
    static int N;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 4;
        parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        if (rank[a] > rank[b]) {
            parent[b] = a;
        } else if (rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            rank[a]++;
        }
    }


    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }


    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
