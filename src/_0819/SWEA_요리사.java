package _0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_요리사 {
    static int[][] map;
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            answer = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            permutation(0, new ArrayList<Integer>());
            System.out.println("answer = " + answer);
        }
    }

    private static void permutation(int index, ArrayList<Integer> temp) {
        if (temp.size() == N / 2) {
            System.out.println(temp);
            makeCook(temp);
            return;
        }

        for (int i = index; i < N; i++) {
            temp.add(i);
            permutation(i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private static void makeCook(ArrayList<Integer> temp) {
        // 차이가 가장 작은 값을 선택해야함.
        int a = temp.get(0);
        int b = temp.get(1);

        int value1 = map[a][b];
        int value2 = map[b][a];

        System.out.println("value1 = " + value1);
        System.out.println("value2 = " + value2);
        System.out.println("(value1+value2) = " + (value1+value2));
        answer = Math.min(map[0][1] + map[1][0], Math.abs(map[0][1] + map[1][0] - value1 + value2));
    }
}
