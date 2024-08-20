package _0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16926
// 내가 푼 것 아님
// 이해 안돼.
public class BOJ_배열돌리기1 {
    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int count = Math.min(n, m) / 2; // 작은값의 절반
        for (int i = 0; i < r; i++) { // R번의 반복

            for (int j = 0; j < count; j++) {
                int temp = arr[j][j]; // 제일 첫번째 값 저장해두기
                // j, n, m이 가지는 의미, 어떻게 구성해야할지, 어떻게 구성 되어 있는지

                for (int k = j + 1; k < m - j; k++) { // 왼쪽으로 이동
                    arr[j][k - 1] = arr[j][k];
                }

                for (int k = j + 1; k < n - j; k++) { // 아래로 이동
                    arr[k - 1][m - j - 1] = arr[k][m - j - 1];
                }

                for (int k = m - j - 2; k >= j; k--) { //
                    arr[n - j - 1][k + 1] = arr[n - j - 1][k];
                }

                for (int k = n - j - 2; k >= j; k--) { //
                    arr[k + 1][j] = arr[k][j];
                }
                arr[j + 1][j] = temp;
            }
        }
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}