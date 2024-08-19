package _0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZC1NpTagf0DFAVs&contestProbId=AWT-lPB6dHUDFAVT&probBoxId=AZFpcS3Ko30DFAVs&type=PROBLEM&problemBoxTitle=0819&problemBoxCnt=3
public class SWEA_햄버거다이어트_NextPermutation {
    static int N, maxCal;
    static int[][] items;
    static int answer;
    /*
        Next Permutation
        단일 시간복잡도: O(N)
        모든 순열을 생성하려면 N!번의 호출,
        시간복잡도: O(N * N!)

        1. 뒤부터 탐색, 오름차순이 깨지는 인덱스 확인 (a) 제일 뒤기준, 제일뒤 한칸앞 (a == -1이 되면 완성)
        2. 다시 뒤부터 탐색, a보다 큰 첫번째 인덱스 확인 (b)
        3. swap(a, b)
        4. a + 1부터 끝까지 오름차순정렬 (맨 앞, 맨 뒤만 바꿔주면 된다)

        e.g)
        a확인         : 1 3(a) 5 4 4
        b확인         : 1 3(a) 5 4 (b)
        (a, b) 스왑   : 1 4(b) 5 4 3(a)
        a + 1부터 정렬 : 1 4 3 4 5
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            init(br); // 초기화
            Arrays.sort(items, Comparator.comparingInt(a -> a[1]));  // 칼로리를 기준으로 정렬

            do {
                int totalCal = 0;
                int totalFavorite = 0;

                for (int i = 0; i < N; i++) {
                    if (totalCal + items[i][1] > maxCal) break;

                    totalFavorite += items[i][0];
                    totalCal += items[i][1];
                }

                answer = Math.max(answer, totalFavorite);
            } while (nextPermutation(items));

            System.out.printf("#%d %d\n", testCase, answer);
        }
    }

    private static void init(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        maxCal = Integer.parseInt(input[1]);
        answer = 0;
        items = new int[N][2];

        // 선호도, 칼로리 저장
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int favorite = Integer.parseInt(input[0]);
            int calories = Integer.parseInt(input[1]);
            items[i][0] = favorite;
            items[i][1] = calories;
        }
    }

    private static boolean nextPermutation(int[][] items) {
        // 1. 오름차순이 깨지는 지점 a를 찾기
        int a = items.length - 2;
        while (a >= 0 && items[a][1] >= items[a + 1][1]) a--; // 계속 오름차순이면 값을 내려서 확인

        if (a == -1) return false; // 모두 정렬이 된 상태 (더이상 갈 수 없음, 탐색 끝)

        // 2. 다시 뒤부터 a보다 큰 값을 찾기
        int b = items.length - 1;
        while (items[a][1] >= items[b][1]) b--; // b값이 큰거를 찾아야 하므로 값을 내림

        // 3. a와 b를 바꾸기
        swap(items, a, b);

        // 4. a + 1부터 오름차순 정렬
        int start = a + 1;
        int end = items.length - 1;
        while (start < end) swap(items, start++, end--);

        return true;
    }

    private static void swap(int[][] items, int a, int b) {
        int[] temp = items[a];
        items[a] = items[b];
        items[b] = temp;
    }
}