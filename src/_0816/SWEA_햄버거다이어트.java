package _0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZC1NpTagf0DFAVs&contestProbId=AWT-lPB6dHUDFAVT&probBoxId=AZFPSVnq3ssDFAVs&type=PROBLEM&problemBoxTitle=0814&problemBoxCnt=2&&&&&&

public class SWEA_햄버거다이어트 {
    static int N, maxCal;
    static ArrayList<int[]> items;
    static int answer;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            init(br); // 초기화

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

        // 선호도, 칼로리 저장
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int favorite = Integer.parseInt(input[0]);
            int calories = Integer.parseInt(input[1]);
            items.add(new int[]{favorite, calories});
        }
    }

    private static void combination(int index, int totalCal, int totalFavorite) {
        if (totalCal > maxCal) return; // 최대 칼로리 이상일 때는 포함 X

        answer = Math.max(answer, totalFavorite); // 가능한 모든 조합의 최대 선호도 갱신

        for (int i = index; i < N; i++) {
            int[] item = items.get(i); // [0]: 선호도 [1]: 칼로리
            combination(i + 1, totalCal + item[1], totalFavorite + item[0]);
        }
    }
}