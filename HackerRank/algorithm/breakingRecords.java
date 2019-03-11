package algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class breakingRecords {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {

        int maximumValue = -1;
        int breakingMaximumCnt = 0;
        int minimumValue = -1;
        int breakingMimimumCnt = 0;

        for (int i = 0; i < scores.length; i++) {
            if (i == 0) {
                maximumValue = scores[i];
                minimumValue = scores[i];
            } else if (scores[i] > maximumValue) {
                maximumValue = scores[i];
                breakingMaximumCnt++;
            } else if (scores[i] < minimumValue) {
                minimumValue = scores[i];
                breakingMimimumCnt++;
            }
        }

        return new int[]{breakingMaximumCnt, breakingMimimumCnt};
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
