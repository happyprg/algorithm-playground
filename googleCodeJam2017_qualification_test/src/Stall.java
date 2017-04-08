import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Stall {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Integer testCases =
                in.nextInt();  // Scanner has functions to read Integers, longs, strings, chars, etc.
        for (Integer readCount = 1; readCount <= testCases; ++readCount) {
            Integer userSeatCount = in.nextInt();
            Integer personCount = in.nextInt();

            Seat[] allSeats = new Seat[userSeatCount];
            Seat lastSeat = null;

            for (Integer i = 0; i < allSeats.length; i++) {
                if (allSeats[i] == null) {
                    allSeats[i] = new Seat(i, 0, allSeats.length - 1, 0, 0, '.');
                }
            }

            if (userSeatCount.compareTo(personCount) == 0) {
                lastSeat = new Seat(0, 0, allSeats.length - 1, 0, 0, '.');
            } else {
                int nowIndex = (userSeatCount / 2) - 1;

                if (userSeatCount % 2 != 0) {
                    nowIndex = (userSeatCount / 2);
                }
                for (Integer i = 1; i <= personCount; i++) {

                    for (int j = 0; j < allSeats.length; j++) {
                        refreshScore(allSeats, j);
                    }

                    int bigGapIndex = 1;
                    for (int j = 0; j < allSeats.length - 1; j++) {

                        if (allSeats[j].getState() != 'O' && (allSeats[j].getScoreSum() > allSeats[bigGapIndex]
                                .getScoreSum())) {
                            bigGapIndex = j;
                        }
                    }
                    boolean isRight = allSeats[bigGapIndex].getLeftScore() > allSeats[bigGapIndex]
                            .getRightScore();
                    if (isRight) {

                        int myIndex = allSeats[bigGapIndex].getLeftIndex();
                        int i1 = bigGapIndex - allSeats[myIndex].getLeftIndex();
                        int i2 = i1 / 2;

                        nowIndex = myIndex + i2;

                    } else {
                        int myIndex = allSeats[bigGapIndex].getMyIndex();
                        int i1 = allSeats[bigGapIndex].getRightIndex() - bigGapIndex;
                        int i2 = 0;
                        i2 = i1 / 2;

                        nowIndex = myIndex + i2;
                        if (allSeats[nowIndex + 1].state == 'O' && allSeats[nowIndex - 1].state != 'O') {
                            nowIndex -= 1;
                        }
                    }
                    allSeats[nowIndex].state = 'O';

                    lastSeat = allSeats[nowIndex];

                    StringBuilder sb = new StringBuilder();
                    for (int z = 0; z < allSeats.length; z++) {
                        sb.append(allSeats[z].getState());
                    }
                }
            }
            System.out.println(
                    "Case #" + readCount + ": " + lastSeat.getMaxValue() + " " + lastSeat.getMinValue());
        }
    }

    private static void refreshScore(Seat[] allSeats, int nowIndex) {
        int leftSeatScore = 0;
        int rightSeatScore = 0;
        int leftIndex = -1;
        int rightIndex = -1;
        for (int j = nowIndex; j < allSeats.length - 1; j++) {
            if (allSeats[j + 1].state != 'O') {
                rightSeatScore++;
            } else {
                rightIndex = j + 1;
                break;
            }
        }

        for (int j = nowIndex; j >= 1; j--) {
            if (allSeats[j - 1].state != 'O') {
                leftSeatScore++;
            } else {
                leftIndex = j - 1;
                break;
            }
        }
        allSeats[nowIndex].leftScore = leftSeatScore;
        allSeats[nowIndex].rightScore = rightSeatScore;
        if (leftIndex != -1) {
            allSeats[nowIndex].leftIndex = leftIndex;
        }
        if (rightIndex != -1) {
            allSeats[nowIndex].rightIndex = rightIndex;
        }
        allSeats[nowIndex].scoreSum = allSeats[nowIndex].getLeftScore() + allSeats[nowIndex].getRightScore();
    }

    public static class Seat

    {
        public int getScoreSum() {
            return scoreSum;
        }

        public int scoreSum = -1;

        public int getMyIndex() {
            return myIndex;
        }

        private int leftIndex = -1;
        private int rightIndex = -1;
        private int leftScore = 0;
        private int rightScore = 0;
        private char state = '.';
        private int myIndex = -1;

        public Seat(int myIndex, int leftIndex, int rightIndex, int leftScore, int rightScore, char state) {
            this.myIndex = myIndex;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.leftScore = leftScore;
            this.rightScore = rightScore;
            this.state = state;
        }

        public int getLeftIndex() {
            return leftIndex;
        }

        public int getRightIndex() {
            return rightIndex;
        }

        public int getRightScore() {
            return rightScore;
        }

        public char getState() {
            return state;
        }

        public int getLeftScore() {
            return leftScore;
        }

        public int getMaxValue() {
            return getLeftScore() > getRightScore() ? getLeftScore() : getRightScore();
        }

        public int getMinValue() {
            return getLeftScore() < getRightScore() ? getLeftScore() : getRightScore();
        }

        @Override
        public String toString() {
            return "Seat{" +
                   "leftIndex=" + leftIndex +
                   ", rightIndex=" + rightIndex +
                   ", leftScore=" + leftScore +
                   ", rightScore=" + rightScore +
                   ", myIndex=" + myIndex +
                   ", scoreSum=" + scoreSum +
                   ", state=" + state +
                   '}';
        }
    }

}
