package _0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZC1NpTagf0DFAVs&contestProbId=AWT-lPB6dHUDFAVT&probBoxId=AZFPSVnq3ssDFAVs&type=PROBLEM&problemBoxTitle=0814&problemBoxCnt=2&&&&&&
public class SWEA_햄버거다이어트 {
    static int N, maxCal;
    static ArrayList<int[]> items;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            init(br);

            combination(0, 0, 0);
            System.out.printf("#%d %d\n", testCase, answer);
        }
    }

    private static void init(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        maxCal = Integer.parseInt(input[1]);
        answer = 0;
        items = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int favorite = Integer.parseInt(input[0]);
            int calories = Integer.parseInt(input[1]);
            items.add(new int[]{favorite, calories});
        }
    }

    private static void combination(int index, int totalCal, int totalFavorite) {
        if (totalCal > maxCal) return;

        answer = Math.max(answer, totalFavorite);

        for (int i = index; i < N; i++) {
            int[] item = items.get(i);
            combination(i + 1, totalCal + item[1], totalFavorite + item[0]);
        }
    }
}