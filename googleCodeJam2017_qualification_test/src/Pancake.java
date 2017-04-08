import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Pancake {

    static char HAPPY_SIDE = '+';
    static char BLANK_SIDE = '-';
    static String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int readCount = 1; readCount <= testCases; ++readCount) {
            char[] pancakes = in.next().toCharArray();
            int flipSize = in.nextInt();
            String flipCount = getFlipCount(pancakes, flipSize);
            System.out.println("Case #" + readCount + ": " + flipCount);
        }
    }

    private static String getFlipCount(char[] pancakes, int flipSize) {
        int flipCount = 0;

        for (int j = 0; j < pancakes.length; j++) {

            boolean isFlipped = false;
            int changeCount = 0;

            if (pancakes[j] == BLANK_SIDE) {
                for (int k = j; k < j + flipSize; k++) {
                    if (pancakes[k] == BLANK_SIDE) {
                        pancakes[k] = HAPPY_SIDE;
                        changeCount++;
                    } else {
                        pancakes[k] = BLANK_SIDE;
                        changeCount++;
                    }
                    if (k == pancakes.length - 1) {
                        break;
                    }
                }
                isFlipped = true;

                //뒤집었는데 뒤집은 수가 flipSize보다 작은 경우 isImpossible
                int z = (j + 1) + flipSize;
                if (isFlipped && changeCount < flipSize
                    && z > pancakes.length) {
                    return IMPOSSIBLE;
                }
            }

            if (isFlipped) {
                flipCount++;
                isFlipped = false;
            }
        }
        return String.valueOf(flipCount);
    }
}
