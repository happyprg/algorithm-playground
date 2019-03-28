package algorithm;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

import org.junit.jupiter.api.Test;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class GCD {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

    @Test
    public void generalizedGCD() {

        int num = 5;
//        int[] arr = new int[]{2, 3, 4, 5, 6};
        int[] arr = { 2, 4, 6, 8, 10 };
        int result = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int standard = arr[i];
            int checkNum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % standard == 0) {
                    checkNum++;
                }
                if (checkNum == num) {
                    result = standard;
                    break;
                }
            }
        }
        if (result == -1) {
            result = 1;
        }
        System.out.println("result = " + result);
    }
}
