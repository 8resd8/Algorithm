package _0820;

// https://www.acmicpc.net/problem/16435

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_스네이크버드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NL = br.readLine().split(" ");
        int N = Integer.parseInt(NL[0]);
        int L = Integer.parseInt(NL[1]);
        ArrayList<Integer> fruit = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreElements()) fruit.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < N; i++) {
            if (Collections.min(fruit) <= L) {
                L++;
                fruit.remove(Collections.min(fruit));
            }
        }
        System.out.println(L);
    }
}