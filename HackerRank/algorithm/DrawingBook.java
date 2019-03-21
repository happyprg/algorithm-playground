package algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class DrawingBook {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        int startToEnd = 0;
        int endToStartCnt = 0;
        for (int i = n; i > 0; i -= ((i % 2) + 1)) {
            if (i % 2 == 0) {
                if (i == p) {
                    break;
                }
            } else {
                if (i == p || (i - 1) == p) {
                    break;
                }
            }

            endToStartCnt++;
        }
        for (int i = 0; i <= n; i += 2) {
            if (i == p || (i + 1) == p) {
                break;
            }
            startToEnd++;
        }
        return endToStartCnt > startToEnd ? startToEnd : endToStartCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
