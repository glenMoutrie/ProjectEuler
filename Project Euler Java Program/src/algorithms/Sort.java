package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

	/* 
	 * Implements Insertion sort a per page 18 of Introduction to Algorithms
	 */
	public static ArrayList<Integer> insertionSort(ArrayList<Integer> unsorted, boolean increasing){

		if (increasing) {
			// Sorting the list in an increasing order
			for (int j = 1; j < unsorted.size(); j++) {
				
				// The value of the next item to be sorted
				int key = unsorted.get(j);

				// Shifting previously sorted values to the right
				int i = j - 1;
				while(i >= 0 && unsorted.get(i) > key){
					unsorted.set(i + 1, unsorted.get(i));
					i--;
				}
				unsorted.set(i + 1, key);
			}
		} else {
			// Sorting the list in a decreasing order
			for (int j = unsorted.size() - 2; j >= 0; j--) {
			 	int key = unsorted.get(j);

				// Shifting previously sorted values to the left
				int i = j + 1;
				while(i < unsorted.size() && unsorted.get(i) > key){
					unsorted.set(i - 1, unsorted.get(i));
					i++;
				}
				unsorted.set(i - 1, key);
			}
		}

		return(unsorted);
	}

	public static ArrayList<Integer> insertionSort(ArrayList<Integer> unsorted) {
		return(insertionSort(unsorted, true));
	}

	public static void main(String args[]){

		Integer[] a = {5, 5, 2, 4, 6, 1, 3};
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));

  
		ArrayList<Integer> sorted = insertionSort(A,true);

		System.out.println(sorted);
		System.out.println(insertionSort(A, false));

	}
}
