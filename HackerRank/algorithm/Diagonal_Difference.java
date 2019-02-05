package algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Diagonal_Difference {

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {

        int leftToRight = 0;
        int leftToRightIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            leftToRight += arr[i][leftToRightIndex++];
        }

        int rightToLeft = 0;
        int rightToLeftIndex = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            rightToLeft += arr[i][rightToLeftIndex--];
        }

        return Math.abs(leftToRight - rightToLeft);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
