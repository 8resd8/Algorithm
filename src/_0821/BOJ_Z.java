package _0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1074

public class BOJ_Z {
    static int count;
    public static void main(String[] args) throws IOException {
        String[] Nrc = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int N = Integer.parseInt(Nrc[0]);
        int r = Integer.parseInt(Nrc[1]);
        int c = Integer.parseInt(Nrc[2]);

        DivideSpace(r, c, (int) Math.pow(2, N)); // 좌표 (r, c), size
        System.out.println(count);
    }

    // 분할 정복..
    static void DivideSpace(int r, int c, int size) {
        if (size == 1) return;
        int half = size / 2;

        if (r < half && c < half) { // 왼쪽 위 1, 카운트 0부터 시작
            DivideSpace(r, c, half);

        } else if (r < half && c >= half) { // 오른쪽 위 2
            count += size*size/4; // size*size 1번째 위치
            DivideSpace(r, c - half, half);

        } else if (r >= half && c < half) { // 왼쪽 아래 3
            count += size*size/4 * 2; // size*size에서 2번째 위치
            DivideSpace(r - half, c, half);

        } else { // 오른쪽 아래 4
            count += size*size/4 * 3; // size*size에서 3번째 위치
            DivideSpace(r - half, c - half, half);
        }
    }
}