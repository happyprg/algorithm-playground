import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TidyNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int readCount = 1; readCount <= testCases; ++readCount) {
            long maxNum = in.nextLong();

            for (long checkingNum = maxNum; checkingNum > 0; checkingNum--) {
                System.out.println("checkingNum = " + checkingNum);
                char[] copyOfOriginalCheckingNum = String.valueOf(checkingNum).toCharArray();
                int isNeedFillZeroIndex = -1;
                boolean skipLessOrderNum = false;

                for (int j = 0; j < copyOfOriginalCheckingNum.length; j++) {

                    //인접한 수의 차이
                    if (j != copyOfOriginalCheckingNum.length - 1) {
                        int aLong = Character.getNumericValue(copyOfOriginalCheckingNum[j]);
                        int aLong1 = Character.getNumericValue(copyOfOriginalCheckingNum[j + 1]);
                        if (aLong > aLong1) {
                            skipLessOrderNum = true;
                            continue;
                        }
                    }

                    //성능을 위해 0이 있는 녀석은 다 빼버리기
                    if (copyOfOriginalCheckingNum[j] == '0' && j != copyOfOriginalCheckingNum.length) {
                        isNeedFillZeroIndex = j;
                        break;
                    }
                }

                //0으로 채워야 할께 있다면 원문을 0으로 다 채우는걸로 고치기
                if (isNeedFillZeroIndex > 0) {
                    for (int k = isNeedFillZeroIndex; k < copyOfOriginalCheckingNum.length; k++) {
                        copyOfOriginalCheckingNum[k] = '0';
                    }
                }

                final boolean b = skipLessOrderNum == false;
                final boolean b2 = isLeadingZero(checkingNum) == false;
                if (b
                    && b2
                        ) {

                    System.out.println("Case #" + readCount + ": " + checkingNum);
                    break;
                }
                checkingNum = Long.valueOf(new String(copyOfOriginalCheckingNum));
            }
        }
    }

    private static boolean isLeadingZero(long value) {
        long thisNum = value;
        while (thisNum != 0) {
            long checkNum = thisNum % 10;
            thisNum = thisNum / 10;
            if (checkNum == 0) {
                return true;
            }
        }
        return false;
    }
}
