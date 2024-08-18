package SWEA특강;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://swexpertacademy.com/main/code/codeBattle/battleDetail.do?categoryId=AY1INdsqPvADFAWX&battleMainPageIndex=1

public class No1_새로운불면증치료법 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int[] arr = new int[10];
            n = Integer.parseInt(br.readLine());
            System.out.printf("#%d %d\n", i + 1, getNumber(arr));
        }
    }

    private static int getNumber(int[] arr) {
        int multiple = 1;

        while (true) {
            int number = n * multiple++;
            boolean check = true;

            while (number > 0) {
                arr[number % 10] = 1;
                number /= 10;
            }

            for (int num : arr) {
                if (num == 0) {
                    check = false;
                    break;
                }
            }

            if (check) return n * (multiple - 1);
        }
    }
}