import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = Math.min(Integer.parseInt(input[0]), Integer.parseInt(input[1])); i <= Math.max(Integer.parseInt(input[0]), Integer.parseInt(input[1])); i++) {
            System.out.print(i + " ");
        }
    }
}
