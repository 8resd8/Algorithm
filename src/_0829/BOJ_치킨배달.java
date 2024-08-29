package _0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_치킨배달 {
    static int N, M, chickenIndex;
    static int[][] map;
    static int[][] chicken;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new int[N][N];
        chicken = new int[N][N];
        chickenIndex = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chicken[chickenIndex][0] = i;
                    chicken[chickenIndex++][1] = j;
                }
            }
        }

        combination(0, new ArrayList<>());
    }

    private static void combination(int index, ArrayList<int[]> temp) {
        if (index == M) {
            // 구하기
            for (int[] ints : temp) {
                System.out.println(Arrays.toString(ints));
            }
            return;
        }

        for (int i = index; i < chickenIndex; i++) {
            temp.add(new int[]{chicken[i][0], chicken[i][1]});
            combination(i + 1, temp);
            temp.remove(temp.size() - 1);
        }

    }
}
