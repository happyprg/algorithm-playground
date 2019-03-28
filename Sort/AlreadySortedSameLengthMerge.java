import java.util.ArrayList;
import java.util.List;

public class AlreadySortedSameLengthMerge {

    public static void main(String[] args) {
        Integer[] arr1 = {
                3, 5, 6, 8, 9
        };
        Integer[] arr2 = {
                1, 2, 4, 7, 10
        };

        List<Integer> result = new ArrayList<>();
        int arr1Cursor = 0;
        int maximumCursor = arr1.length - 1;
        int arr2Cursor = 0;
        while (arr1Cursor <= maximumCursor) {
            if (arr1[arr1Cursor] > arr2[arr2Cursor]) {
                result.add(arr2[arr2Cursor++]);
            } else {
                result.add(arr1[arr1Cursor++]);
            }
        }
        while (arr2Cursor <= arr2.length - 1) {
            result.add(arr2[arr2Cursor++]);
        }

        System.out.println("result = " + result);

    }

}
