package _0816;

// https://www.acmicpc.net/problem/2023

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_신기한소수 {
    static ArrayList<Integer> prime;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prime = new ArrayList<>();
//        checkPrime((int) Math.pow(10, N));
//        System.out.println(prime);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = (int) Math.pow(10, N); i < (int) Math.pow(10, N + 1); i++) {
            System.out.println(i);
            // 1. 문자열을 1, 2, 3... N개까지 쪼개기
            cutNumber(String.valueOf(i));
            // 2. 쪼갠 숫자의 소수를 구하기
//            combinationN(result, new ArrayList<>(), 0);
        }
        System.out.println(result);
    }

    private static void cutNumber(String number) {
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("쪼갤 숫자: " + number);
        for (int i = 1; i <= number.length(); i++) {
            String s = number.substring(0, i);
//            numbers.add(Integer.valueOf());
            System.out.println("s = " + s);
        }
    }

    private static void combinationN(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int start) {
        // N자리 수의 조합만 생성
        if (temp.size() == N) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < N; i++) {
            temp.add(i);
            combinationN(result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private static void checkPrime(int maxValue) {
        boolean[] isCheck = new boolean[maxValue + 1];
        for (int i = 2; i <= maxValue; i++) {
            isCheck[i] = true;
        }

        for (int i = 2; i <= maxValue; i++) {
            if (isCheck[i]) {
                for (int j = i * i; j <= maxValue; j += i) {
                    isCheck[j] = false;
                }
            }
        }

        for (int i = 2; i <= maxValue; i++) {
            if (isCheck[i]) prime.add(i);
        }
    }
}