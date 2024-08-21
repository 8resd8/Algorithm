package _0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_추억의2048게임 {
    static int[][] map;
    static int[][] user;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
        int t = 1;

        for (int i = 0; i < t; i++) {
//            String[] input = br.readLine().split(" ");
//            n = Integer.parseInt(input[0]);
            n = 4;
//            String move = input[1];
            String move = "up";
            user = new int[n][n];
//            map = new int[n][n];
            map = new int[][]{
                    {4, 8, 2, 4, 0},
                    {4, 4, 2, 0, 8},
                    {8, 0, 2, 4, 4},
                    {2, 2, 2, 2, 8},
                    {0, 2, 2, 0, 0},
            };
//            map = new int[][]{
//                    {2, 0, 2, 4},
//                    {2, 0, 4, 2},
//                    {2, 2, 4, 8},
//                    {2, 2, 4, 4},
//            };

//            for (int j = 0; j < n; j++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                for (int k = 0; k < n; k++) {
//                    map[j][k] = Integer.parseInt(st.nextToken());
//                }
//            }

            switch (move) {
                case "up":
                    moveUp();
                    break;
                case "down":
                    moveDown();
                    break;
                case "right":
                    break;
                case "left":
                    break;
            }


        }
    }

    private static void moveDown() {
        // 아래로 더하기
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // 위 아래 값이 둘 다 존재 && 같은 값이라면
                if (map[j][i] > 0 && map[j][i] == map[j + 1][i]) {
                    map[j + 1][i] += map[j][i];

                    map[j][i] = 0; // 값 지워주기
                    j++;
                }

            }
        }


        System.out.println("값 더하기");
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }

        // 값 옮기기
        for (int i = n - 1; i >= 0; i--) {
            int zeroIndex = -1;

            for (int j = n - 1; j >= 0; j--) {
                if (map[j][i] == 0 && zeroIndex == -1) {
                    zeroIndex = j;
                } else if (zeroIndex != -1 && map[j][i] > 0) {
                    map[zeroIndex][i] = map[j][i];
                    map[j][i] = 0;
                    zeroIndex = -1;
                    j = n - 1;
                }


            }

        }
//
        System.out.println("-- down -- ");
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void moveUp() {
        // 값 더하기
        for (int i = 0; i < n; i++) {
            int valueIndex = -1;
            for (int j = 0; j < n - 1; j++) {
                if (valueIndex == -1 && map[j][i] > 0) {
                    valueIndex = j;
                }

                // 위 아래 값이 둘 다 존재 && 같은 값이라면
//                if (map[j][i] > 0 && map[j][i] == map[j + 1][i]) {
//                    map[j][i] += map[j + 1][i];
//
//                    map[j + 1][i] = 0; // 값 지워주기
//                    j++;
//                }
                if (valueIndex != -1 && map[valueIndex][i] == map[j][i]) {
                    map[valueIndex][i] *= 2;
                    valueIndex = -1;
                }

            }
        }
//        System.out.println("값 더하기");
//        for (int[] ints : map) {
//            System.out.println(Arrays.toString(ints));
//        }

        // 값 옮기기
//        System.out.println("값 이동시키기");
        for (int i = 0; i < n; i++) {
            int zeroIndex = -1;

            for (int j = 0; j < n; j++) {
                if (map[j][i] == 0 && zeroIndex == -1) {
                    zeroIndex = j;
                } else if (zeroIndex != -1 && map[j][i] > 0) {
                    map[zeroIndex][i] = map[j][i];
                    map[j][i] = 0;
                    zeroIndex = -1;
                    j = 0;
                }


            }

        }

        System.out.println("-- UP -- ");
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static void swap(int a, int b) {
        int[] temp = map[a];
        map[a] = map[b];
        map[b] = temp;
    }
}