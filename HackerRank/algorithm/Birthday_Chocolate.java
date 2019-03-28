package algorithm;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Birthday_Chocolate {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            int sum = 0;
            List<Integer> tempSum = new ArrayList<>();
            for (int j = i; j < i + m; j++) {
                if (i + m > s.size()) {
                    break;
                }
                sum += s.get(j);
                tempSum.add(s.get(j));
            }
            if (sum == d) {
                result.add(tempSum);
            }
        }
        return result.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
