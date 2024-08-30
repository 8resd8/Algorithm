package _0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 수업_MST프림 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점 수
        int[][] adj = new int[V][V];
        boolean[] visted = new boolean[V]; // 방문여부
        int[] minEdge = new int[V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adj[i][j] = sc.nextInt();
            }
        }
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0; // 0번 정점을 트리의 시작점 되도록 함(어떤 정점이든 상관x)

        int cost = 0;
        int i = 0;
        for (i = 0; i < V; i++) {
            // 1. 트리 구성에 포함될 가장 유리할 정점 선택 (최솟값 찾기)
            int min = Integer.MAX_VALUE;
            int minVertex = -1;

            for (int j = 0; j < V; j++) {
                if (visted[j]) continue;
                if (min > minEdge[j]) {
                    minVertex = j;
                    min = minEdge[j];
                }
            }
            if (minVertex == -1) break;
            visted[minVertex] = true;
            cost += min;

            // 2. 선택된 정점과 타 정점들 간선비용 비교 (간보기)
            for (int j = 0; j < V; j++) {
                if (!visted[j] && adj[minVertex][j] != 0 && minEdge[j] > adj[minVertex][j]) {
                    minEdge[j] = adj[minVertex][j];
                }
            }

        }

        System.out.println(i == V ? cost : -1);
    }
}
/*
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
*/