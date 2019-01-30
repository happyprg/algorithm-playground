import java.util.Scanner;

public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {
        for (int z = 1; z <= n; z++) {
            StringBuilder sb = new StringBuilder();
            for (int i = (n - 1) - z; i >= 0; i--) {
                sb.append(' ');
            }
            for (int k = z; k > 0; k--) {
                sb.append('#');
            }
            System.out.println(sb.toString());
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
