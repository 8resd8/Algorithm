package _0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_Ladder1 {
	static int[][] visited;
	static int[][] map;
	static int[] dy = { -1, 1, 0 }; // 왼쪽, 오른쪽 위
	static int[] dx = { 0, 0, -1 };
	static int size = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			br.readLine();

			map = new int[size][size];
			visited = new int[size][size];
			StringTokenizer st;
			int x = 0, y = 0;

			for (int j = 0; j < size; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j2 = 0; j2 < size; j2++) {
					map[j][j2] = Integer.parseInt(st.nextToken());

					if (map[j][j2] == 2) {
						x = j;
						y = j2;
					}
				}
			}

			System.out.println(bfs(x, y));
		}

	}

	private static int bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { a, b });
		visited[a][b] = 1;
		int answer = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];

			if (x == 0) {
				return y;
			}

			for (int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && visited[nx][ny] == 0 && map[nx][ny] == 1) {
					queue.add(new int[] { nx, ny });
					visited[nx][ny] = 1;
					break; // 움직이면 중단
				}
			}

		}

		return answer;
	}
}
