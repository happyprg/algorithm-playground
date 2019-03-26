package algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Cats_and_a_Mouse {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {

        int distanceCatAAndMouseC = Math.abs(z - x);
        int distanceCatBAndMouseC = Math.abs(z - y);

        if (distanceCatAAndMouseC > distanceCatBAndMouseC) {
            return "Cat B";
        }
        if (distanceCatAAndMouseC < distanceCatBAndMouseC) {
            return "Cat A";
        }
        return "Mouse C";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
