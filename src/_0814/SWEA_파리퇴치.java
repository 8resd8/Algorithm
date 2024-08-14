package _0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZC1NpTagf0DFAVs&contestProbId=AV5PzOCKAigDFAUq&probBoxId=AZFPSVnq3ssDFAVs&type=PROBLEM&problemBoxTitle=0814&problemBoxCnt=2
public class SWEA_파리퇴치 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(input.nextToken());
            M = Integer.parseInt(input.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                input = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < N; k++) {
                    map[i][k] = Integer.parseInt(input.nextToken());
                }
            }

            System.out.printf("#%d %d\n", testCase, getAnswer());
        }
    }

    private static int getAnswer() {
        int maxSum = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                maxSum = Math.max(maxSum, getSum(i, j));
            }
        }
        return maxSum;
    }

    private static int getSum(int i, int j) {
        int sum = 0;
        for (int y = i; y < i + M; y++) {
            for (int x = j; x < j + M; x++) {
                if (y < 0 || y >= N || x < 0 || x >= N) continue;
                sum += map[y][x];
            }
        }
        return sum;
    }
}