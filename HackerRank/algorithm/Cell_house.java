package algorithm;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Cell_house {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

    @Test
    public void cellCompete() {

//        int[] states = new int[]{1, 0, 0, 0, 0, 1, 0, 0};
        int[] states = new int[]{1, 1, 1, 0, 1, 1, 1, 1};
        int days = 2;
        int leftEndCell = 0;
        int rightEndCell = 0;

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < days; j++) {
            if (j > 0) {
                states = result.stream().mapToInt(i -> i).toArray();
                result.clear();
            }
            for (int i = 0; i < states.length; i++) {
                if (i > 0) {
                    leftEndCell = states[i - 1];
                } else {
                    leftEndCell = 0;
                }
                if (i < states.length - 1) {
                    rightEndCell = states[i + 1];
                } else {
                    rightEndCell = 0;
                }

                if (leftEndCell == rightEndCell) {
                    result.add(0);
                } else {
                    result.add(1);
                }
            }
        }

        System.out.println("result = " + result);

    }
}
