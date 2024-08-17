package SWEA특강;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1_새로운불면증치료법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int value = n;
            int[] arr = new int[10];
            int count = 0;

            while (true) {
                value = n * 2;
                n *= count;
//                System.out.println("value = " + value);
                boolean check = true;

                while (value > 0) {
                    int num = value % 10;

                    value /= 10;
                    arr[num]++;
                    count++;
                }

                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j] + " ");
                    if (arr[j] == 0) {
                        check = false;
//                        break;
                    }
                }
                System.out.println();



                if (check) {
                    System.out.printf("#%d %d\n", i + 1, count);
                    break;
                }
                break;
            }


        }
    }
}
