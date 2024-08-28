package _0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_창용마을무리의개수 {
    static int N, M;
    static int[] parent, rank;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String[] NM = br.readLine().split(" ");
            N = Integer.parseInt(NM[0]);
            M = Integer.parseInt(NM[1]);
            parent = new int[N + 1];
            rank = new int[N + 1];
            check = new boolean[N + 1];
            int count = 0;

            // makeSet
            for (int i = 1; i < N + 1; i++) {
                parent[i] = i;
                rank[i] = 0; // 랭크는 0 설정
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            for (int i = 1; i < N + 1; i++) {
                find(i); // 모든 노드 find호출하여 부모 최신화 (경로압축 후 최신화)
            }

            for (int i = 1; i < N + 1; i++) {
                if (!check[parent[i]]) {
                    check[parent[i]] = true;
                    count++;
                }
            }

            sb.append("#").append(tc + 1).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        if (rank[a] > rank[b]) { // 크면 작은값으로 바꾸기
            parent[b] = a;
        } else if (rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            rank[a]++;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]); // 더 빠르다
    }
}