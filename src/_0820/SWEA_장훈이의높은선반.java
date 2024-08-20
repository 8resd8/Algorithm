package _0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZC1NpTagf0DFAVs&contestProbId=AV2b7Yf6ABcBBASw&probBoxId=AZFtceBKVJUDFAVs&type=PROBLEM&problemBoxTitle=0820&problemBoxCnt=3

public class SWEA_장훈이의높은선반 {
    static int N, B, answer;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            answer = Integer.MAX_VALUE;
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            number = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }

            // 역순 정렬
            Arrays.sort(number);
            int start = 0;
            int end = number.length - 1;
            while (start < end) {
                int temp = number[start];
                number[start++] = number[end];
                number[end--] = temp;
            }

            combination(0, 0);
            System.out.printf("#%d %d\n", testCase, Math.abs(answer - B));
        }
    }

    private static void combination(int index, int sum) {
        if (sum >= B) {
            answer = Math.min(answer, sum);
            return;
        }
        if (answer == B) return; // 0보다 작은 수는 없음

        for (int i = index; i < N; i++) {
            combination(i + 1, sum + number[i]);
        }
    }
}