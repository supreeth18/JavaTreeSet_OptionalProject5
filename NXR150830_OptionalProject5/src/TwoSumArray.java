/**
 * Public class Arrays implementing methods from Optional Project 4.
 * Given an array A of integers, and an integer X, find how many pairs of
   elements of A sum to X:
 * Use Java's TreeSet or TreeMap to solve the following problems.
 * @author Nagasupreeth Ramesh (nxr150830)
 */

import java.util.TreeMap;
import java.util.ArrayList;


public class TwoSumArray {

	static int howMany(int[] A, int X) { 
		int hm = 0;

		TreeMap<Integer, ArrayList<Integer>> tmap = new TreeMap<Integer, ArrayList<Integer>>();

		ArrayList<Integer> list;

		for (int i = 0; i < A.length; i++) {
			list = tmap.get(A[i]);
			if (list == null) {
				list = new ArrayList<Integer>();
			}
			list.add(i);
			tmap.put(A[i], list);
		}

		Integer fk = X;

		while(fk != null) {
			int temp = tmap.floorKey(fk);
			
			if ((X-temp) == temp) {
				int s = tmap.get(temp).size();
				hm += (s*(s-1)/2);
			} else if (tmap.get(X - temp) != null) {
				hm += (tmap.get(X-temp).size() * tmap.get(temp).size());
				tmap.remove(X-temp);
			}
			fk = tmap.lowerKey(temp);
		}

		return hm;
    }

    public static void main (String[] args) {
    	int[] A = {3, 3, 4, 5, 3, 5, 6, 2, 4};
    	int hm = howMany(A, 8);
    	System.out.println(hm);
    }
}
