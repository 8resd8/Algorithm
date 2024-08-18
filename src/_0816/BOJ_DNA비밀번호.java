package _0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/12891

public class BOJ_DNA비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] SP = br.readLine().split(" ");
        int S = Integer.parseInt(SP[0]);
        int P = Integer.parseInt(SP[1]);

        String input = br.readLine();   // S길이 문자열 입력
        int[] requireACGT = new int[4]; // 요구하는 문자 사용 개수
        int[] currentACGT = new int[4];     // 현재 문자 사용 개수

        // 문제 조건 A C G T 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            requireACGT[i] = Integer.parseInt(st.nextToken());
        }

        // 초기값 (문자를 몇 번 썼는지) 확인
        int answer = 0;
        for (int i = 0; i < P; i++) {
            addChar(input.charAt(i), currentACGT);
        }
        if (checkAnswer(requireACGT, currentACGT)) answer++; // 처음 만든 문자에서 조건 만족 할 수 있음


        for (int i = P; i < S; i++) {
            removeChar(input.charAt(i - P), currentACGT);       // 첫번째 값은 지우고
            addChar(input.charAt(i), currentACGT);              // 마지막 값은 추가
            if (checkAnswer(requireACGT, currentACGT)) answer++;// 조건에 맞는 문자 개수 만큼 썼는지 확인
        }

        System.out.println(answer); // 결과
    }

    private static boolean checkAnswer(int[] requireACGT, int[] current) {
        for (int i = 0; i < 4; i++) {
            if (current[i] < requireACGT[i]) return false; // 요구 개수보다 미만으로 사용하면 X
        }
        return true;
    }

    private static void addChar(char c, int[] current) {
        switch (c) {
            case 'A':
                current[0]++;
                break;
            case 'C':
                current[1]++;
                break;
            case 'G':
                current[2]++;
                break;
            case 'T':
                current[3]++;
                break;
        }
    }

    private static void removeChar(char c, int[] current) {
        switch (c) {
            case 'A':
                current[0]--;
                break;
            case 'C':
                current[1]--;
                break;
            case 'G':
                current[2]--;
                break;
            case 'T':
                current[3]--;
                break;
        }
    }
}