import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by jeehong.lee on 2016. 4. 9..
 */
public class RevengeOfThePancakes {

	static char HAPPYSIDE_CHAR = '+';
	static char BLANKSIDE_CHAR = '-';

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String n = in.next();
			System.out.println("Case #" + i + ": " + processing(n));
		}
	}

	static int processing(String pancakeStack) {

		int flipCnt = 0;
		char[] pancakeStat = pancakeStack.toCharArray();

		boolean isSingleSideMenuOnlyHappySide = checkOnlyHappySideMenu(pancakeStat);
		if (isSingleSideMenuOnlyHappySide) {
			return flipCnt;
		} else {

			char[] pancakeArr = pancakeStat;
			boolean isLineUp = false;

			while (true) {

				if (isLineUp) {
					break;
				}

				int lastFlipIndexOfPancakeStack = -1;
				for (int i = 0; i < pancakeArr.length; i++) {

					if (pancakeArr.length > i + 1) {

						if (pancakeArr[i] != pancakeArr[i + 1]) {
							lastFlipIndexOfPancakeStack = i;
							break;
						}
					} else {
						if (pancakeArr[i] == BLANKSIDE_CHAR) {
							lastFlipIndexOfPancakeStack = i;
						}
					}
				}

				if (lastFlipIndexOfPancakeStack >= 0) {
					pancakeArr = doFlip(lastFlipIndexOfPancakeStack, pancakeArr);
					flipCnt++;
					isLineUp = checkOnlyHappySideMenu(pancakeArr);
				}
			}
		}

		return flipCnt;
	}

	private static boolean checkOnlyHappySideMenu(char[] pancakeStat) {

		Set<Character> sideMenuUniqueSet = new HashSet<>();
		for (int i = 0; i < pancakeStat.length; i++) {
			sideMenuUniqueSet.add(pancakeStat[i]);
		}
		return sideMenuUniqueSet.size() == 1 && sideMenuUniqueSet.contains(HAPPYSIDE_CHAR);
	}

	private static char[] doFlip(int lastBlankSideNum, char[] pancakeArr) {
		for (int i = 0; i <= lastBlankSideNum; i++) {
			if (pancakeArr[i] == HAPPYSIDE_CHAR) {
				pancakeArr[i] = BLANKSIDE_CHAR;
			} else if (pancakeArr[i] == BLANKSIDE_CHAR) {
				pancakeArr[i] = HAPPYSIDE_CHAR;
			}
		}
		return pancakeArr;
	}
}
