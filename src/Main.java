import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, b, answer;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            number = new int[n];
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }


            permutation(0, 0);
            System.out.printf("#%d %d\n", tc, Math.abs(answer - b));
        }
    }

    public static void permutation(int index, int sum) {
        if (sum >= b) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = index; i < n; i++) {
            permutation(i + 1, sum + number[i]);
        }
    }
}