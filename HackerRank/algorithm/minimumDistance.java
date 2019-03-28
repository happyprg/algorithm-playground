package algorithm;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class minimumDistance {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
        // WRITE YOUR CODE HERE
        return -1;
    }

    @Test
    public void findLocation() {
        int numRows = 3;
        int numColumns = 3;

        List<List<Integer>> area = Arrays.asList(
                Arrays.asList(1, 0, 0),
                Arrays.asList(1, 0, 0),
                Arrays.asList(1, 9, 1)
        );
        List<Integer> ordered = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            int disconnectedColumnsCnt = 0;
            for (int j = 0; j < numColumns; j++) {
                if (area.get(i).get(j) == 9) {
                    ordered.add(i);
                    ordered.add(j);
                } else if (area.get(i).get(j) == 0) {
                    disconnectedColumnsCnt++;
                }
            }
            if (disconnectedColumnsCnt == numColumns) {
                System.out.println("-1 = " + -1);
            }
        }

        int numRowCnt = 0;
        int numCloumnCnt = 0;
        for (int i = 0; i < ordered.get(0); i++) {

            for (int j = 0; j < ordered.get(1); j++) {

                if (area.get(i).get(j) == 1) {
                    numRowCnt++;
                    continue;
                }
            }
        }

        System.out.println("ordered = " + ordered);
    }
}
