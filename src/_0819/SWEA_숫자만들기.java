package _0819;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWIeRZV6kBUDFAVH&solveclubId=AZC1NpTagf0DFAVs&problemBoxTitle=0819&problemBoxCnt=3&probBoxId=AZFpcS3Ko30DFAVs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_숫자만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int n    = Integer.parseInt(br.readLine()); // 넘버의 개수
            // 연산자의 개수
            String[] operator = br.readLine().split(" "); // + - * /
            String[] numbers = br.readLine().split(" ");

            // 연산자의 모든 조합을 구함
            permutation(numbers, 0, new ArrayList<>());
        }
    }

    private static void permutation(String[] operator, int index, ArrayList<Character> temp) {
//        if (temp.isEmpty()) return;

        for (int i = 0; i < operator.length; i++) {
            // 연산자의 모든 조합 구하기
        }
    }
}
