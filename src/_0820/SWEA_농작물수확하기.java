package _0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZC1NpTagf0DFAVs&contestProbId=AV7GLXqKAWYDFAXB&probBoxId=AZFtceBKVJUDFAVs&type=PROBLEM&problemBoxTitle=0820&problemBoxCnt=1

public class SWEA_농작물수확하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            // 별찍기 느낌으로?
            int mid = n / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (i <= mid) { // 위 + 중간
                    for (int j = mid - i; j <= mid + i; j++) {
                        sum += map[i][j];
                    }
                } else { // 아래
                    for (int j = i - mid; j < n - (i - mid); j++) {
                        sum += map[i][j];
                    }
                }
            }

            System.out.println("#" + testCase + " " + sum);
        }
    }
}
