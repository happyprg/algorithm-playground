import java.util.Scanner;

public class Mini_Max_Sum {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        long maxValue = arr[0];
        long minValue = arr[0];
        long sumValue = 0L;
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
            sumValue += arr[i];
        }

        System.out.println((sumValue - maxValue) + " " + (sumValue - minValue));
    }

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
