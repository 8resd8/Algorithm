package _0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZC1NpTagf0DFAVs&contestProbId=AWbrg9uabZsDFAWQ&probBoxId=AZFzR6NKC9oDFAXd&type=PROBLEM&problemBoxTitle=0821&problemBoxCnt=3&&&&&&

public class SWEA_추억의2048게임 {
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            String[] input = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            n = Integer.parseInt(input[0]);
            String move = input[1];
            map = new int[n][n];

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // left, right, down 경우만 돌려
            if (move.equals("left")) {
                rotate(2); // 오른쪽으로 돌리고
                move();            // 합치고
                rotate(1); // 원상복구
            } else if (move.equals("right")) {
                rotate(1); // 왼쪽으로 돌리고
                move();            // 합치고
                rotate(2); // 원상복구
            } else if (move.equals("down")) {
                rotate(3); // 뒤집고
                move();            // 합치고
                rotate(3); // 원상복구
            } else {
                move(); // 위로만 합침
            }

            sb.append("#").append(tc + 1).append("\n");
            for (int[] nums : map) {
                for (int num : nums) {
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }

    private static void move() {
        // 1. 값을 합친다
        // 1-1: 값이 같은 경우: 원래 인덱스의 값이 2배
        // 1-2: 값이 다른 경우: 인덱스 위에 값을 올린다.
        // 2. 저장한 값을 map에 저장

        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            boolean[] indexUsed = new boolean[n];
            Arrays.fill(indexUsed, true);
            int index = 0;

            for (int j = 0; j < n; j++) {
                if (map[j][i] != 0) { // 숫자가 있으면
                    if (index > 0 && indexUsed[index - 1] && temp[index - 1] == map[j][i]) { // 같은 숫자가 있으면
                        temp[index - 1] *= 2; // 합치기 (2배)
                        map[j][i] = 0; // 합친건 없애기
                        indexUsed[index - 1] = false; // 이미 더한 자리는 그만해
                    } else {
                        temp[index++] = map[j][i]; // 값이 다르면 다음 인덱스 쌓기
                    }
                }
            }

            // 결과를 저장, 합친 결과만 남아있어서 뒤에 0으로 자동으로 채워짐
            for (int j = 0; j < n; j++) {
                map[j][i] = temp[j];
            }
        }
    }

    public static void rotate(int direction) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (direction == 1)      temp[n - 1 - j][i] = map[i][j]; // left
                else if (direction == 2) temp[j][n - i - 1] = map[i][j]; // right
                else if (direction == 3) temp[n - i - 1][j] = map[i][j]; // down
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(temp, 0, map, 0, temp.length);
        }
    }
}