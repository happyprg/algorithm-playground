import java.util.Scanner;

public class Mini_Max_Sum_Dynamic_Arr {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        int cntOfSumElements = 4;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long sumOfMinToCntOfSumElements = 0;
        for (int i = 0; i < cntOfSumElements; i++) {
            sumOfMinToCntOfSumElements += arr[i];
        }
        long sumOfMaxToCntOfSumElements = 0;
        for (int i = arr.length - 1; i >= arr.length - cntOfSumElements; i--) {
            sumOfMaxToCntOfSumElements += arr[i];
        }
        System.out.println(sumOfMinToCntOfSumElements + " " + sumOfMaxToCntOfSumElements);
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
