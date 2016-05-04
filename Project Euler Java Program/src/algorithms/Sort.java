package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Sort {

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
	
	public static Integer[] merge(Integer[] A, int p, int q, int r) {
		
		// Indexing for the two splits
		int nOne = q - p + 1;
		int nTwo = r - q;
		
		// Initiate the two splits
		int[] right = new int[nOne + 1];
		int[] left = new int[nTwo + 1];
		int i, j;
		
		// Populate left
<<<<<<< Updated upstream
		for(int i = 1; i <= nOne; i++) {
			System.out.println(i);
			left[i - 1] = A[p + i - 1];
=======
		for(i = 0; i < nOne; i++) {
			left[i] = A[p + i - 1];
>>>>>>> Stashed changes
		}
		
		// Populate right
		for(j = 0; j < nTwo; j++) {
			right[j] = A[q + j];
		}
		
		// Add sentinal cards
		// (usually infinity, but I've just set it to the int storage limit)
		left[nOne] = Integer.MAX_VALUE;
		right[nTwo] = Integer.MAX_VALUE;
		
<<<<<<< Updated upstream
		int i = 1;
		int j = 1;
		
		for(int k = p; k <= r; k++) {
			if (left[i] <= right[i]) {
				A[k] = left[i];
				i++;
			} else {
				A[k] = right[i];
				j++;
			}
		}
=======
		i = 0;
		j = 0;
>>>>>>> Stashed changes
		
		// Now perform the merge sort
		for (int k = p; k < r; k++) {
			if (left[i] <= right[j]) {
				A[k] = left[i];
				i++;
			} else {
				A[k] = right[j];
				j++;
			}
		}
		
		return(A);
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
		
<<<<<<< Updated upstream
		int[] b = {2, 4, 5, 7, 1, 2, 3, 6};
		
		System.out.println(merge(b,0,3,7));
=======
		Integer[] result = merge(a, 0,3,6);
		for(Integer i : result) System.out.println(i);
>>>>>>> Stashed changes

	}
}
