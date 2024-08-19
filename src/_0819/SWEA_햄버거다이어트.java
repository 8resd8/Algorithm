package _0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA_햄버거다이어트 {
    static int N, maxCal;
    static ArrayList<int[]> items;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            init(br); // 초기화

            Collections.sort(items, (a, b) -> Integer.compare(a[1], b[1])); // 칼로리를 기준으로 정렬

            do {
                int totalCal = 0;
                int totalFavorite = 0;

                for (int i = 0; i < N; i++) {
                    if (totalCal + items.get(i)[1] > maxCal) {
                        break;  // 현재 칼로리를 초과하면 가지치기
                    }
                    totalCal += items.get(i)[1];
                    totalFavorite += items.get(i)[0];
                }

                answer = Math.max(answer, totalFavorite);

            } while (nextPermutation(items));

            System.out.printf("#%d %d\n", testCase, answer);
        }
    }

    private static void init(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        maxCal = Integer.parseInt(input[1]);
        answer = 0;
        items = new ArrayList<>();

        // 선호도, 칼로리 저장
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int favorite = Integer.parseInt(input[0]);
            int calories = Integer.parseInt(input[1]);
            items.add(new int[]{favorite, calories});
        }
    }

    private static boolean nextPermutation(ArrayList<int[]> array) {
        int i = array.size() - 1;
        while (i > 0 && array.get(i - 1)[1] >= array.get(i)[1]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = array.size() - 1;
        while (array.get(j)[1] <= array.get(i - 1)[1]) {
            j--;
        }

        Collections.swap(array, i - 1, j);

        j = array.size() - 1;
        while (i < j) {
            Collections.swap(array, i, j);
            i++;
            j--;
        }

        return true;
    }
}
