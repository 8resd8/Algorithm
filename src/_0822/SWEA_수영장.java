package _0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_수영장 {
    static int[] plan, prices;
    static int minPrice;
    static int maxIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            prices = new int[4];
            // 이용권 가격
            for (int i = 0; i < 4; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }
            plan = new int[13];
            // 12월 이용 계획
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
                if (plan[i] != 0) maxIndex = i;
            }

            // 1년 이용권은 바로 구하기
            minPrice = prices[3];

            // 모든 경우의 수 탐색
            dfs(1, 0);
            System.out.printf("#%d %d\n", tc + 1, minPrice);
        }
    }

    private static void dfs(int index, int sumPrice) {
//        System.out.printf("index: %d, sum: %d \n", index, sumPrice);
        if (index >= 13) {
            minPrice = Math.min(minPrice, sumPrice);
            return;
        }
//        if (minPrice <= sumPrice) return;



        if (plan[index] == 0) {
            dfs(index + 1, sumPrice);
        } else {
            dfs(index + 1, sumPrice + plan[index] * prices[0]); // 1일권은 다 쓴다고 생각하고 다음달로 넘김
            dfs(index + 1, sumPrice + prices[1]); // 1달권
            dfs(index + 3, sumPrice + prices[2]); // 3달권

        }
    }
}
/*
10
10 40 100 300
0 0 2 9 1 5 0 0 0 0 0 0

10
10 100 50 300
0 0 0 0 0 0 0 0 6 2 7 8
*/