package algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SockMerchant {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairCnt = 0;
        Set<Integer> uniqueTypes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int sameCnt = 0;
            int searchValue = ar[i];
            if (uniqueTypes.contains(searchValue)) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (searchValue == ar[j]) {
                    sameCnt++;
                }
            }
            pairCnt += sameCnt / 2;
            uniqueTypes.add(searchValue);
        }
        return pairCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
