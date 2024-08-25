package _0823;

import java.util.ArrayList;
import java.util.Arrays;

public class 연습_순열찾기 {
    static int N, count;
    static ArrayList<int[]> list;
    static boolean[] visited;

    public static void main(String[] args) {
        N = 4;
        list = new ArrayList<>();
        visited = new boolean[N];
        for (int i = 0; i < N * 2; i += 2) {
            list.add(new int[]{i, i + 1});
        }
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();

        permutation1(0,new ArrayList<>());
        System.out.println("count = " + count);
    }

    private static void permutation1(int index, ArrayList<int[]> temp) {
        if (temp.size() == N) {
            for (int[] ints : temp) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println();
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp.add(list.get(i));

            permutation1(i , temp);

            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
