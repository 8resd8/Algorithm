package _0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_암호만들기 {
    static int L, C;
    static char[] chars;
    static String moum = "aeiou";
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] LC = br.readLine().split(" ");
        L = Integer.parseInt(LC[0]);
        C = Integer.parseInt(LC[1]);
        chars = new char[C];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < C; i++) {
            chars[i] = input[i].charAt(0);
        }

        StringBuilder sb = new StringBuilder();
        combination(0, "");
        Collections.sort(list);
        for (String s : list) {
            char[] abc = s.toCharArray();
            String string = Arrays.toString(abc);
            for (char c : abc) {
                System.out.print(c);
            }
            System.out.println();
            sb.append(string).append("\n");
        }
//        System.out.println(sb);


//        for (String s : list) {
//            char[] cc = s.toCharArray();
//            Arrays.sort(cc);
//            sb.append(cc).append("\n");
//            System.out.println(Arrays.toString(c));
//            System.out.println(s);
//        }

//        System.out.println(sb);
    }

    private static void combination(int index, String s) {
        if (s.length() == L) {
            char[] c = s.toCharArray();
            if (check(s)) {
//                Arrays.sort(c);
//                System.out.println(Arrays.toString(c));
                list.add(Arrays.toString(c));
            }
//            return;
        }

        for (int i = index; i < C; i++) {
            combination(i + 1, s + chars[i]);
        }
    }

    private static boolean check(String s) {
        boolean m = false;
        // 모음 체크
        for (char c : moum.toCharArray()) {
            if (s.indexOf(c) != -1) {
                m = true;
                break;
            }
        }

        boolean j = false;
        int count = 0;
        for (char c : moum.toCharArray()) {
            if (s.indexOf(c) == -1) {
                count++;
            }
            if (count >= 2) {
                j = true;
                break;
            }
        }

        return m && j;
    }
}
