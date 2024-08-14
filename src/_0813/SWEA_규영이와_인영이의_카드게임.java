package _0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_규영이와_인영이의_카드게임 {
	static int[] visited;
	static int inSum, guSum;
	static int[] gu;
	static int[] in;
	static int size;
	static int answer1;
	static int answer2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringBuilder sb = new StringBuilder();
			gu = new int[9];
			in = new int[9];
			visited = new int[9];
			answer1 = 0;
			answer2 = 0;

			int[] number = new int[19];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 규영이의 카드 입력
			for (int j = 0; j < gu.length; j++) {
				gu[j] = Integer.parseInt(st.nextToken());
				guSum += gu[j];
				number[gu[j]]++;
			}

			// 인영이의 카드는 규영이가 없는 카드로 입력을 해야한다
			for (int j = 1, count = 0; j < number.length; j++) {
				if (number[j] == 0)
					in[count++] = j;
			}

			// 인영이가 가지는 모든 경우의 수
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			ArrayList<Integer> temp = new ArrayList<>();
			pumutation(temp);

			sb.append("#").append(i + 1).append(" ").append(answer1).append(" ").append(answer2);

			System.out.println(sb);
		}
	}

	private static void pumutation(ArrayList<Integer> temp) {
		if (temp.size() == 9) {
			guSum = 0;
			inSum = 0;

			int sum = 0;
			for (int i = 0; i < 9; i++) {
				sum = gu[i] + temp.get(i);

				if (gu[i] > temp.get(i)) {
					guSum += sum;
				} else if (temp.get(i) > gu[i]) {
					inSum += sum;
				}
			}

			if (guSum > inSum) {
				answer1++;
			} else if (guSum < inSum) {
				answer2++;
			}

			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i] == 1)
				continue;

			temp.add(in[i]);
			visited[i] = 1;
			pumutation(temp);

			visited[i] = 0;
			temp.remove(temp.size() - 1);
		}

	}
}