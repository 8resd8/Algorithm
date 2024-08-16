package _0816;

// https://www.acmicpc.net/problem/20055

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Study_BOJ_컨베이어벨트위의로봇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] NK = br.readLine().split(" ");
//        int N = Integer.parseInt(NK[0]);
//        int K = Integer.parseInt(NK[1]);
        int N = 3 * 2;
        int K = 2;
        int[] durability = new int[N];
        int[] robot = new int[N];
        int count = 0;
//        String[] input = br.readLine().split(" ");
        String[] input = {"1", "2", "1", "2", "1", "2"};

        // 내구도 입력
        for (int i = 0; i < N; i++) {
            durability[i] = Integer.parseInt(input[i]);
        }

        // 1. 벨트에 있는 모든 로봇을 오른쪽 방향으로 한 칸 이동
        // 2. 이동하는 조건1: 제일 오른쪽에 있는 로봇이 움직이려고 할 때 그 칸은 빈칸 이어야한다.
        // 3. 이동하는 조건2: 내구도가 1 이상 이어야한다.
        // 4. 첫번째 칸이 내구도가 "0보다 크면" 로봇을 올린다.
        // 5. 종료 조건: 내구도가 0인 칸의 개수가 K개 이상 -> 종료 아니라면 1번 이동

        while (count < K) {
            // 벨트에 있는 모든 로봇을 이동

            // 로봇이 있는 마지막 위치 확인
            int lastIndex = 0;
            for (int i = 0; i < N; i++) {
                if (robot[i] == 0) continue;
                lastIndex = i;
                break;
            }

            for (int i = 0; i < N; i++) {

            }


        }


    }
}