package _0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 1; testCase <= 10; testCase++) {
            StringBuilder sb = new StringBuilder();
            br.readLine(); // 필요없는데 입력을 줌 왜주는거지?
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Queue<Integer> queue = new ArrayDeque<>();
            int downCount = 1; // 1 ~ 5까지 감소

            // 1. 입력
            while (st.hasMoreElements()) queue.add(Integer.parseInt(st.nextToken()));

            while (!queue.isEmpty()) {
                if (queue.peek() - downCount <= 0) {
                    queue.remove();
                    queue.add(0);
                    break;
                }

                // 2. 숫자를 1 감소시키고 뒤로 보내기

                queue.add(queue.poll() - downCount++);
                // 3. 5를 넘어가면 1로 바꿔줌
                if (downCount > 5) downCount = 1;
            }


            System.out.printf("#" + testCase + " ");
            for (Integer number : queue) {
                System.out.printf(number + " ");
            }
            System.out.println();
        }
    }
}