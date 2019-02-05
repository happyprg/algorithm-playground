package algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class birthdayCakeCandles {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the algorithm.birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int[][] maxValue = new int[1][2];

        for (int i = 0; i < ar.length; i++) {
            if (maxValue[0][0] < ar[i]) {
                maxValue[0][0] = ar[i];
                maxValue[0][1] = 1;
            } else if (maxValue[0][0] == ar[i]) {
                maxValue[0][1] += 1;
            }
        }

        return maxValue[0][1];
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
