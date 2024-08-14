package _0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_N과M1 {
	static boolean[] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		visited = new boolean[N];

		int[] nums = new int[N];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}

		pumutation(result, nums, temp);

		StringBuilder sb = new StringBuilder();
		for (ArrayList<Integer> arr : result) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void pumutation(ArrayList<ArrayList<Integer>> result, int[] nums, ArrayList<Integer> temp) {
		if (temp.size() == M) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			temp.add(nums[i]);
			visited[i] = true;
			pumutation(result, nums, temp);

			visited[i] = false;
			temp.remove(temp.size() - 1);
		}

	}
}