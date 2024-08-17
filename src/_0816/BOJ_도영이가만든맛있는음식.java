package _0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2961
public class BOJ_도영이가만든맛있는음식 {
    static int N;
    static ArrayList<int[]> cook;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cook = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sinTasty = Integer.parseInt(st.nextToken()); // 신 맛
            int ssnTasty = Integer.parseInt(st.nextToken()); // 쓴 맛
            cook.add(new int[]{sinTasty, ssnTasty}); // 요리 맛 저장
        }

        cookCombination(0, 1, 0); // 0번 인덱스부터, 신 맛은 곱셈이므로 1, 덧셈은 0부터 시작
        System.out.println(answer);
    }

    private static void cookCombination(int index, int sinTasty, int ssnTasty) {
        if (index > 0) answer = Math.min(answer, Math.abs(sinTasty - ssnTasty)); // 재료가 있는 경우만 계산

        for (int i = index; i < N; i++) {
            int[] item = cook.get(i); // 신 맛, 쓴 맛 꺼내기
            cookCombination(i + 1, item[0] * sinTasty, item[1] + ssnTasty); // 신맛은 곱하고 쓴맛은 더하기
        }
    }
}