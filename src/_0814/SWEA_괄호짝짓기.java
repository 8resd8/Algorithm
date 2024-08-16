package _0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD
public class SWEA_괄호짝짓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            br.readLine(); // n의 개수
            String input = br.readLine();
            int[] frequency = new int[4];

            for (char c : input.toCharArray()) {
                switch (c) {
                    case '(':frequency[0]++; break;
                    case ')':frequency[0]--; break;
                    case '[':frequency[1]++; break;
                    case ']':frequency[1]--; break;
                    case '{':frequency[2]++; break;
                    case '}':frequency[2]--; break;
                    case '<':frequency[3]++; break;
                    case '>':frequency[3]--; break;
                }
            }

            // 1: 유효함 0: 유효하지 않음
            int answer = 1;
            for (int number : frequency) {
                if (number % 2 != 0) {
                    answer = 0;
                    break;
                }
            }

            System.out.printf("#%d %d\n", (i + 1), answer);
        }
    }
}