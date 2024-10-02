package _1002;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_최장증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] list = new int[n + 1];
            for (int j = 0; j < n; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }

            int[] LIS = new int[n + 1];
            int e = 0;
            for (int j = 0; j < n; j++) {
                int idx = binary(LIS, 0, e - 1, list[j]);
                LIS[idx] = list[j];
                if (e == idx) e++;
            }

            System.out.println("#" + (i + 1) + " " + e);

        }
    }

    private static int binary(int[] arr, int s, int e, int value) {
        while (s <= e) {
            int mid = (s + e) / 2;

            if (arr[mid] < value) {
                s = mid + 1;
            } else if (arr[mid] > value) {
                e = mid - 1;
            } else {
                return mid; // 인덱스
            }
        }
        return s; // 인덱스
    }
}
