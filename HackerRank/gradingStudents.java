import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class gradingStudents {

    private static final Scanner scan = new Scanner(System.in);

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        /*
         * Write your code here.
         */
        int[] result = new int[grades.length];
        int noNeedToRound = 38;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < noNeedToRound) {
                result[i] = grades[i];
                continue;
            }
            int numberOfFirstDigit = grades[i] % 10;
            int checkingRange = 10 - numberOfFirstDigit;
            for (int j = 1; j <= checkingRange; j++) {
                int searchingMultipleOfFive = numberOfFirstDigit + j;
                if (searchingMultipleOfFive % 5 == 0) {
                    int multipleOfFive = ((grades[i] / 10) * 10) + searchingMultipleOfFive;
                    if (multipleOfFive - grades[i] < 3) {
                        grades[i] = multipleOfFive;
                    }
                    break;
                }
            }
        }
        return grades;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
