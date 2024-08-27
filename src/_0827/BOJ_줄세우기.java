package _0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// https://www.acmicpc.net/problem/2252

public class BOJ_줄세우기 {
    static int N, M;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]); // 사람을 정점으로 생각
        M = Integer.parseInt(NM[1]); // 키를 비교한 횟수
        inDegree = new int[N + 1]; // 차수가 0인 간선의 정보, 보통 정점은 1부터 시작하는 경우가 많음
        adj = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        // 입력 (M번)
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            adj.get(a).add(b); // 그래프의 간선 연결시키기 a -> b로 가기때문에 b의 값을 증가
//            adj.get(b).add(a); // 단방향 설정 (양방향 x)
            inDegree[b]++; // b의 진입차수를 늘려야한다. (a -> b)
        }

        // 진입차수가 0인 값 큐에 넣기
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) { // 0은 사용하지 않고 1부터 N까지 사용
            if (inDegree[i] == 0) { // a -> b, i를 큐에 넣음
                queue.add(i);
            }
        }

        // 큐가 빌 때까지 반복한다
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curNode = queue.poll(); // 큐에서 노드를 꺼내고
            result.add(curNode); // 결과 리스트에 추가

            ArrayList<Integer> list = adj.get(curNode); // 현재 노드의 인접리스트 갖오기
            for (Integer num : list) {
                inDegree[num]--; // 해당하는 노드로 들어오는 간선 하나 제거
                if (inDegree[num] == 0) { // 진입차수가 0이 되면 큐에 추가
                    queue.add(num);
                }
            }
        }

        for (Integer node : result) {
            // a가 b보다 앞에 온다는 조건만 만족한다면
            // 위상 정렬은 여러 가지 가능한 정렬 결과를 얻을 수 있음
            System.out.print(node + " ");
        }
    }
}