package _0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_치킨배달 {
    static int N, M, answer;
    static int[][] map;
    static ArrayList<int[]> chicken, homes;

    public static void main(String[] args) throws IOException {
        init();
        combination(0, new ArrayList<>());
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new int[N][N];
        chicken = new ArrayList<>();
        homes = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        // 집, 치킨의 위치를 저장
        // 치킨집 M개 고르는 조합을 구함
        // 그 조합과 집의 위치를 거리계산

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)    chicken.add(new int[]{i + 1, j + 1}); // 치킨 좌표
                else if (map[i][j] == 1) homes.add(new int[]{i + 1, j + 1}); // 집 좌표
            }
        }
    }

    private static void combination(int index, ArrayList<int[]> temp) {
        if (temp.size() == M) {
            calculation(temp);
            return;
        }

        for (int i = index; i < chicken.size(); i++) {
            temp.add(new int[]{chicken.get(i)[0], chicken.get(i)[1]}); // 치킨집 위치
            combination(i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private static void calculation(ArrayList<int[]> temp) {
        int sum = 0;
        for (int[] home : homes) {
            int min = Integer.MAX_VALUE;
            for (int[] chicken : temp) {
                min = Math.min(min, Math.abs(chicken[0] - home[0]) + Math.abs(chicken[1] - home[1]));
            }
            sum += min;
        }

        answer = Math.min(answer, sum);
    }
}