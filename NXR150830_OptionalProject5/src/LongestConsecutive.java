import java.util.Set;
import java.util.TreeSet;

/**
 * @author Nagasupreeth (nxr150830)
 * Given an array A of integers, find the length of a longest streak of
   consecutive integers that occur in A (not necessarily contiguously):
   static int longestStreak(int[] A) { // RT = O(nlogn).
 *
 */
public class LongestConsecutive {
	public int longestConsecutive(int[] array) {
		if (array.length < 2)
			return 1;
		Set<Integer> set = new TreeSet<>();
		for (int elements : array) {
			set.add(elements);
		}
		int numberoflongestconsecutiveelements = 0;
		for (int n : set) {
			if (!set.contains(n - 1)) {
				int m = n + 1;
				while (set.contains(m)) {
					m++;
				}
				numberoflongestconsecutiveelements = Math.max(
						numberoflongestconsecutiveelements, m - n);
			}
		}
		return numberoflongestconsecutiveelements;
	}

	public static void main(String[] args) {
		int[] array = { 1, 7, 9, 4, 1, 7, 4, 8, 7, 1 }; // Sample input 1
		int[] arraySecond = { 100, 4, 200, 1, 3, 2 }; // sample input 2
		int[] arrayThird = { 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 }; // sample
																			// input
																			// 3
		LongestConsecutive obj = new LongestConsecutive();
		System.out
				.println("The output for the array -> 1,7,9,4,1,7,4,8,7,1 is -> "
						+ obj.longestConsecutive(array)); // output->3

		System.out
				.println("The output for the array -> 100, 4, 200, 1, 3, 2 is -> "
						+ obj.longestConsecutive(arraySecond)); // output->4

		System.out
				.println("The output for the array ->36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 is -> "
						+ obj.longestConsecutive(arrayThird)); // output->5
	}
}
