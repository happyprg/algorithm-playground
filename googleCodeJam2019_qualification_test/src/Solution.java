import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int readCount = 1; readCount <= testCases; ++readCount) {
            long targetValue = Long.parseLong(in.next());
            char[] chars = String.valueOf(targetValue).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '4') {
                    chars[i] = '1';
                } else {
                    chars[i] = '0';
                }
            }
            String maskingTexts = new String(chars);
            if (maskingTexts.length() > 1) {
                maskingTexts = maskingTexts.replaceFirst("0", "");
            }
            long minus = Long.parseLong(maskingTexts);
            long getFirstPosition = targetValue % 10;
            if (minus == 0L) {
                if (getFirstPosition == 5) {
                    minus = 2;
                } else {
                    minus = 1;
                }
            }
            long result = targetValue - minus;
            System.out.println("Case #" + readCount + ": " + result + " " + minus);
        }
    }

}
