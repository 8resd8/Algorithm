import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, L, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NLD = br.readLine().split(" ");
        N = Integer.parseInt(NLD[0]);
        L = Integer.parseInt(NLD[1]);
        D = Integer.parseInt(NLD[2]);

        int maxTime = N * D;
        int count = 0;
        int i = 0;
        for (i = 0; i < N; i++) { // N번 반복
            count += L; // L초간 안내멘트, 연결 불가능 시간

            for (int j = L+1; j < L+5; j++) { // 안내멘트 이후 5초안에 연결 요청시 가능
                count++;
                if (count % D == 0) { // 요청시간이 일치하면 출력 후 종료
                    System.out.println(count);
                    return;
                }
            }

        }

        // 강제로 연결시  걸리는 최대 시간
        System.out.println(N * D);
    }
}