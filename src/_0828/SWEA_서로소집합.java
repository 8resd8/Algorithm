package _0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_서로소집합 {
    static int n, m;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String[] nm = br.readLine().split(" ");
            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);
            numbers = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                numbers[i] = i;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                String[] input = br.readLine().split(" ");
                int type = Integer.parseInt(input[0]);
                int a = Integer.parseInt(input[1]);
                int b = Integer.parseInt(input[2]);

                if (type == 0) {
                    union(a, b);
                } else if (type == 1) {
                    if (find(a) == find(b)) sb.append(1);
                    else sb.append(0);
                }
            }


            System.out.println("#" + (tc + 1) + " " + sb);
        }
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return;
        // 합쳐주기
        // aRoot에 b루트를 합치기
        if (aRoot < bRoot) {
            numbers[bRoot] = aRoot;
        } else {
            numbers[aRoot] = bRoot;
        }

    }

    private static int find(int a) {
        if (numbers[a] == a) return a;
        return numbers[a] = find(numbers[a]); // 경로압축
    }
}