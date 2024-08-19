package _0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZC1NpTagf0DFAVs&contestProbId=AWT-lPB6dHUDFAVT&probBoxId=AZFPSVnq3ssDFAVs&type=PROBLEM&problemBoxTitle=0814&problemBoxCnt=2&&&&&&

public class SWEA_햄버거다이어트 {
    static int N, maxCal;
    static int[][] items;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            init(br); // 초기화

            Arrays.sort(items, Comparator.comparing(a -> a[1])); // 칼로리를 기준으로 정렬

            do {
                int totalCal = 0;
                int totalFavorite = 0;

                for (int i = 0; i < N; i++) {
                    if (totalCal + items[i][1] <= maxCal) {
                        totalCal += items[i][1];
                        totalFavorite += items[i][0];
                    } else {
                        break;
                    }
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
        items = new int[N][2];

        // 선호도, 칼로리 저장
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int favorite = Integer.parseInt(input[0]);
            int calories = Integer.parseInt(input[1]);
            items[i][0] = favorite;
            items[i][1] = calories;
        }
    }

    private static boolean nextPermutation(int[][] array) {
        int i = array.length - 1;
        // 나보다 작은 값의 인덱스 찾는 과정
        while (i > 0 && array[i - 1][1] >= array[i][1]) {
            i--;
        }

        // 작은값이 없다면 경우의 수 다 찾은 것
        if (i <= 0) {
            return false;
        }


        int j = array.length - 1;
        while (array[j][1] <= array[i - 1][1]) {
            j--;
        }

        swap(array, i - 1, j);

        j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
