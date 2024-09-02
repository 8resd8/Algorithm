package _0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZC1NpTagf0DFAVs&contestProbId=AV5V4A46AdIDFAWu&probBoxId=AZGwpexap_4DFAXd+&type=PROBLEM&problemBoxTitle=0902&problemBoxCnt=++1+

public class SWEA_벌꿀채취 {
    static int N, M, C, answer;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()); // 별통의 크기
            C = Integer.parseInt(st.nextToken()); // 채취 가능한 최대 양
            map = new int[N][N];
            answer = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }




            System.out.println("#" + tc + " " + answer);
        }
    }
}