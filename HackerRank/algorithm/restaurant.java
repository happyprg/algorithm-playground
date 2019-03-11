package algorithm;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

import org.junit.Test;

import java.util.*;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class restaurant {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

    @Test
    public void findLocation() {
        int totalRestaurants = 3;
        List<List<int[]>> allLocations = Arrays.asList(
                Arrays.asList(new int[]{1, 2}),
                Arrays.asList(new int[]{3, 4}),
                Arrays.asList(new int[]{1, -1}));
        int numRestaurants = 2;

        List<LocationAndScore> result = new ArrayList<>(totalRestaurants);

        for (int i = 0; i < allLocations.size(); i++) {
            List<int[]> locations = allLocations.get(i);
            int[] location = locations.get(0);
            int x = location[0];
            int y = location[1];
            double squaredSum = Math.pow(x, 2) + Math.pow(y, 2);
            double sqrt = Math.sqrt(squaredSum);
            result.add(new LocationAndScore(locations, sqrt));
        }
        Collections.sort(result, Comparator.comparingDouble(LocationAndScore::getSqrt));
        List<LocationAndScore> locationAndScores = result.subList(0, numRestaurants);
        List<List<Integer>> finalResult = new ArrayList<>();
        for (int i = 0; i < locationAndScores.size(); i++) {

            List<int[]> locations = locationAndScores.get(i).getLocations();
            int[] ints = locations.get(0);
            finalResult.add(Arrays.asList(ints[0], ints[1]));
        }
        System.out.println("finalResult = " + finalResult);
    }

    public static class LocationAndScore {

        List<int[]> locations;
        double sqrt;

        public LocationAndScore(List<int[]> locations,
                                double sqrt) {

            this.locations = locations;
            this.sqrt = sqrt;
        }

        public List<int[]> getLocations() {
            return locations;
        }

        public double getSqrt() {
            return sqrt;
        }
    }
}
