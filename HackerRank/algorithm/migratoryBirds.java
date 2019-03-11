package algorithm;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class migratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

        return arr.stream().collect(groupingBy(e -> e, summingInt(x -> 1)))
                .entrySet().stream().collect(groupingBy(Map.Entry::getKey, summingLong(Map.Entry::getValue)))
                .entrySet().stream().collect(groupingBy(Map.Entry::getValue, groupingBy(Map.Entry::getKey)))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getKey)).get().getValue()
                .entrySet().stream().min(Comparator.comparingInt(Map.Entry::getKey)).get().getKey();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
