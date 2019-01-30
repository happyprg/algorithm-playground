import java.util.Scanner;

public class Plus_Minus {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int plusCnt = 0;
        int minusCnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                plusCnt++;
            } else if (arr[i] < 0) {
                minusCnt++;
            } else {
                zeroCnt++;
            }
        }

        double positiveFormatted = (double) plusCnt / (double) arr.length;
        System.out.format("%.6f%n", positiveFormatted);
        double negativeFormatted = (double) minusCnt / (double) arr.length;
        System.out.format("%.6f%n", negativeFormatted);
        double zeroFormatted = (double) zeroCnt / (double) arr.length;
        System.out.format("%.6f%n", zeroFormatted);
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
