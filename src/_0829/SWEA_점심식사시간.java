package _0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_점심식사시간 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token;
    static StringBuilder sb;
    static int[][] field;
    static int numberOfPeople, N, ay, ax, by, bx, answer;
    static int[] selected, distFromA, distFromB;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            makeSubSet(0);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void makeSubSet(int depth) {
        if (depth == numberOfPeople) {
            calculateMinute();
            return;
        }

        //A 계단을 선택하는 경우
        selected[depth] = 0;
        makeSubSet(depth + 1);

        //B 계단을 선택하는 경우
        selected[depth] = 1;
        makeSubSet(depth + 1);
    }

    private static void calculateMinute() {
        Queue<Integer> queueA = new ArrayDeque<>();
        Queue<Integer> queueB = new ArrayDeque<>();
        int[] distA = Arrays.copyOf(distFromA, numberOfPeople);
        int[] distB = Arrays.copyOf(distFromB, numberOfPeople);
        boolean[] visited = new boolean[numberOfPeople];

        //queueA의 사이즈는 field[ay][ax]
        for (int i = 0; i < field[ay][ax]; i++) {
            queueA.offer(0);
        }
        //queueB의 사이즈는 field[by][bx]
        for (int i = 0; i < field[by][bx]; i++) {
            queueB.offer(0);
        }

        int minute = 0;
        int peopleInA = 0;
        int peopleInB = 0;
        int readyA = 0;
        int readyB = 0;
        boolean over = false;
        while (!over) {
            over = true;
            //1초가 지나면
            minute++;
            //먼저 빠지고
            int count;
            if ((count = queueA.poll()) > 0) peopleInA -= count;
            if ((count = queueB.poll()) > 0) peopleInB -= count;

            //사람들 이동.
            for (int i = 0; i < numberOfPeople; i++) {
                if (selected[i] == 0) {
                    distA[i]--;
                    if (distA[i] == -1 && !visited[i]) {     //이미 도착한 사람 말고 새로 도착한 사람이 있다면 대기 큐에 넣어주세요.
                        visited[i] = true;
                        readyA++;
                    }
                    if (distA[i] > -1) over = false;     //아직 도착하지 않은 사람이 있다면 종료 하면 안됨
                } else {
                    distB[i]--;
                    if (distB[i] == -1 && !visited[i]) {
                        visited[i] = true;
                        readyB++;
                    }
                    if (distB[i] > -1) over = false;
                }
            }

            //대기 중인 사람 큐가 비어있다면 0을 추가 비어있지 않다면 그 숫자만큼을 추가.
            if (readyA > 0 && peopleInA < 3) {
                int cnt = 0;
                while (readyA > 0 && peopleInA < 3) {
                    peopleInA++;
                    readyA--;
                    cnt++;
                }
                queueA.offer(cnt);
            } else queueA.offer(0);

            if (readyB > 0 && peopleInB < 3) {
                int cnt = 0;
                while (readyB > 0 && peopleInB < 3) {
                    peopleInB++;
                    readyB--;
                    cnt++;
                }
                queueB.offer(cnt);
            } else queueB.offer(0);

            //두 계단 중에서 아직 대기하고 있는 사람이 있으면 종료하면 안됨
            if (readyA > 0 || readyB > 0) over = false;
        }

        //계단에 남아있는 사람들 처리
        int remainA = 0;
        int remainB = 0;
        while (!queueA.isEmpty() && peopleInA > 0) {
            remainA++;
            int count;
            if ((count = queueA.poll()) > 0) peopleInA -= count;
        }

        while (!queueB.isEmpty() && peopleInB > 0) {
            remainB++;
            int count;
            if ((count = queueB.poll()) > 0) peopleInB -= count;
        }

        minute += Math.max(remainA, remainB);
        answer = Math.min(answer, minute);
    }

    private static void init() throws IOException {
        sb = new StringBuilder();
        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        field = new int[N][N];
        distFromA = new int[11];
        distFromB = new int[11];
        answer = Integer.MAX_VALUE;
        numberOfPeople = 0;
        ay = ax = by = bx = -1;
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(token.nextToken());
                if (field[i][j] >= 2) {
                    if (ay == -1) {
                        ay = i;
                        ax = j;
                    } else {
                        by = i;
                        bx = j;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (field[i][j] == 1) {
                    distFromA[numberOfPeople] = Math.abs(i - ay) + Math.abs(j - ax);
                    distFromB[numberOfPeople++] = Math.abs(i - by) + Math.abs(j - bx);
                }
            }
        }
        selected = new int[numberOfPeople];
    }
}