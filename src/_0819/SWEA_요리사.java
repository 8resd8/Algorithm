package _0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZC1NpTagf0DFAVs&contestProbId=AWIeUtVakTMDFAVH&probBoxId=AZFpcS3Ko30DFAVs&type=PROBLEM&problemBoxTitle=0819&problemBoxCnt=3

public class SWEA_요리사 {
    static int[][] map;
    static int N;
    static int answer;
    static ArrayList<ArrayList<Integer>> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            result = new ArrayList<>();
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
            makeCook();
            System.out.printf("#%d %d\n", testCase + 1, answer);
        }
    }

    private static void permutation(int index, ArrayList<Integer> temp) {
        if (temp.size() == N / 2) { // O(N/(N/2))
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < N; i++) {
            temp.add(i);
            permutation(i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private static void makeCook() {
        // 차이가 가장 작은 값을 선택해야함. O(N^2)

        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> teamA = result.get(i);
            ArrayList<Integer> teamB = new ArrayList<>();

            // teamB를 teamA에 속하지 않은 멤버들로 구성
            for (int j = 0; j < N; j++) {
                if (!teamA.contains(j)) {
                    teamB.add(j);
                }
            }

            int sumA = 0, sumB = 0;

            // teamA의 능력치 계산
            for (int a = 0; a < teamA.size(); a++) {
                for (int b = 0; b < teamA.size(); b++) {
                    sumA += map[teamA.get(a)][teamA.get(b)];
                }
            }

            // teamB의 능력치 계산
            for (int a = 0; a < teamB.size(); a++) {
                for (int b = 0; b < teamB.size(); b++) {
                    sumB += map[teamB.get(a)][teamB.get(b)];
                }
            }

            // 두 팀의 능력치 합의 차이를 구하고, 최소값 갱신
            int diff = Math.abs(sumA - sumB);
            if (diff < answer) {
                answer = diff;
            }
        }

    }
}