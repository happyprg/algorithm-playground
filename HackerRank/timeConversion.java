import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class timeConversion {

    private static final Scanner scan = new Scanner(System.in);

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        int hh = Integer.parseInt(s.substring(0, 2));
        if (hh == 12 && s.substring(s.length() - 2).equals("AM")) {
            hh = 0;
        } else if (hh < 12 && s.substring(s.length() - 2).equals("PM")) {
            hh = hh + 12;
        }
        return String.format("%02d", hh) + s.substring(2, s.length() - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
