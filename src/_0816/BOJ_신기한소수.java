package _0816;

// https://www.acmicpc.net/problem/2023

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_신기한소수 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 모든 소수를 구하기에 2, 3, 5, 7로만 시작
        checkNumber(2, 1);
        checkNumber(3, 1);
        checkNumber(5, 1);
        checkNumber(7, 1);
    }

    private static void checkNumber(int number, int digit) {
        if (digit == N && checkPrime(number)) { // N자리 완성 && 소수
            System.out.println(number);         // 값 출력
            return;
        }

        for (int i = 0; i < 10; i++) {
            int nowNumber = number * 10 + i;
            if (checkPrime(nowNumber)) {                // 현재 값이 소수라면
                checkNumber(nowNumber, digit + 1); // 다음 자리 수 생성
            }
        }
    }


    private static boolean checkPrime(int checkNumber) {
        if (checkNumber < 2) return false;
        for (int i = 2; i <= Math.sqrt(checkNumber); i++) {
            if (checkNumber % i == 0) return false; // 나누어 떨어지면 소수가 아니다
        }
        return true; // 소수 확인
    }
}