import java.util.Arrays;

public class NotSortedSameLengthMerge {

    public static void main(String[] args) {
        int[] arr = {
                3, 5, 6, 8, 9,
                1, 2, 4, 7, 10
        };
        System.out.println("arr = " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + 1] = tmp[part1 + i];
        }
    }

}
