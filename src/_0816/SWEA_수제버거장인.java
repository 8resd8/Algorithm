package _0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWErcQmKy6kDFAXi

public class SWEA_수제버거장인 {
    static int N, M, answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]); // N까지 모든 부분집합 구해야함.
            M = Integer.parseInt(input[1]);
            answer = 0;
            visited = new boolean[N];

            // 1. 중복된 숫자를 입력 받지 않기 위한 배열
            ArrayList<int[]> containCheck = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                input = br.readLine().split(" ");
                containCheck.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
            }

            combination(new ArrayList<>(), 1, containCheck);
            System.out.printf("#%d %d\n", i + 1, answer);
        }
    }

    private static void combination(ArrayList<Integer> temp, int start, ArrayList<int[]> containCheck) {
        // 중복된 조합이 있다면 포함 X
        for (int[] numbers : containCheck) {
            if (temp.contains(numbers[1]) && temp.contains(numbers[0])) return;
        }

        answer++; // 가능한 모든 조합 포함

        for (int i = start; i <= N; i++) {
            temp.add(i);
            combination(temp, i + 1, containCheck);
            temp.remove(temp.size() - 1);
        }
    }
}