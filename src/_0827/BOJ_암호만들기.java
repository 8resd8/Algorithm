package _0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1759

public class BOJ_암호만들기 {
    static int L, C;
    static char[] chars;
    static String moum = "aeiou";
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();

        combination(0, "");
        Collections.sort(list);

        print();
    }

    private static void combination(int index, String s) {
        if (s.length() == L && check(s)) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            list.add(new String(c));
            return;
        }

        for (int i = index; i < C; i++) {
            combination(i + 1, s + chars[i]);
        }
    }

    private static boolean check(String s) {
        boolean m = false;
        boolean j = false;

        int count = 0;
        for (char c : s.toCharArray()) {
            if (moum.indexOf(c) == -1) count++;  // 자음 체크
            if (moum.indexOf(c) != -1) m = true; // 모음 체크
            if (count >= 2) j = true;
        }

        return m && j;
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        System.out.print(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] LC = br.readLine().split(" ");
        L = Integer.parseInt(LC[0]);
        C = Integer.parseInt(LC[1]);
        chars = new char[C];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
    }
}