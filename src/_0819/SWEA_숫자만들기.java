package _0819;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWIeRZV6kBUDFAVH&solveclubId=AZC1NpTagf0DFAVs&problemBoxTitle=0819&problemBoxCnt=3&probBoxId=AZFpcS3Ko30DFAVs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_숫자만들기 {
    static int[] operatorCount, numbers;
    static int maxResult, minResult, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init(br);

            permutation(1, numbers[0]); // 연산자 순열, 0은 기본값이니 index 1부터
            System.out.println("#" + testCase + " " + (maxResult - minResult));
        }
    }

    private static void init(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine()); // 숫자의 개수
        numbers = new int[n];
        minResult = Integer.MAX_VALUE;
        maxResult = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        operatorCount = new int[4]; // + - * / 개수 저장
        for (int i = 0; i < 4; i++) {
            operatorCount[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }


    private static void permutation(int index, int sum) {
        if (index == n) { // 연산자를 모두 선택한 경우
            maxResult = Math.max(maxResult, sum);
            minResult = Math.min(minResult, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operatorCount[i] > 0) { // 연산기호 모두 뽑을 때까지
                operatorCount[i]--;

                // 연산자가 아닌 numbers의 index는 따로 매개변수로 설정
                switch (i) {
                    case 0: // +
                        permutation(index + 1, sum + numbers[index]); // 0 + 1, 1 + 2...
                        break;
                    case 1: // -
                        permutation(index + 1, sum - numbers[index]);
                        break;
                    case 2: // *
                        permutation(index + 1, sum * numbers[index]);
                        break;
                    case 3: // /
                        permutation(index + 1, sum / numbers[index]);
                        break;

                }
                operatorCount[i]++; // 재귀 나왔으면 원상복구
            }
        }
    }
}